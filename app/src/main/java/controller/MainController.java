package controller;

import model.Item;
import model.Member;
import view.ConsoleUi;

public class MainController {
  private ConsoleUi view;
  private MemberRegisterController registerController;
  private MemberController memberController;
  private ItemController itemController;
  private Time time;

  public MainController(ConsoleUi view, MemberRegisterController registerController, MemberController memberController, ItemController itemController, Time time) {
    this.view = view;
    this.registerController = registerController;
    this.memberController = memberController;
    this.itemController = itemController;
    this.time = time;
  }

  public void start() {
    createMainMenu();
  }
  
  public void createMainMenu() {
    switch (view.printMainMenu()) {
      case CREATE_MEMBER:
          registerController.createMember();
          createMainMenu();
        break;
      case SELECT_SPECIFIC_MEMBER:
          Member member = registerController.selectMember();
          createSpecificMemberMenu(member);
        break;
      case SHOW_SIMPLE_WAY:
          registerController.showMembersSimple();
          createMainMenu();
        break;
      case SHOW_VERBOSE_WAY:
          registerController.showMembersVerbose();
          createMainMenu();
        break;
      case ADVANCE_ONE_DAY:
        time.advanceDay();
        createMainMenu();
        break;
      case QUIT:
        view.closeScanner();
        return;
    }
  }

  public void createSpecificMemberMenu(Member member) {
    switch (view.printSpecificMemberMenu()) {
      case SHOW_INFORMATION:
        memberController.showFullMemberInformation(member);
        createSpecificMemberMenu(member);
        break;
      case CHANGE_INFORMATION:
        createChangeMemberInformationMenu(member);
        break;
      case CREATE_ITEM:
        memberController.createItem(member);
        createSpecificMemberMenu(member);
        break;
      case SELECT_ITEM:
        Item item = memberController.selectItem(member);
        createSpecificItemMenu(item, member);
        break;
      case CREATE_CONTRACT:
        Item itemToLend = memberController.selectItem(member);
        itemController.establishContract(itemToLend, member);
        createMainMenu();
        break;
      case DELETE_MEMBER:
        registerController.deleteMember(member);
        createMainMenu();
        break;
      case BACK:
        createMainMenu();
    }
  }

  public void createChangeMemberInformationMenu(Member member) {
    switch (view.printChangeInformationMenu()) {
      case CHANGE_FIRST_NAME:
        memberController.changeFirstName(member);
        createSpecificMemberMenu(member);
        break;
      case CHANGE_LAST_NAME:
        memberController.changeLastName(member);
        createSpecificMemberMenu(member);
        break;
      case CHANGE_EMAIL:
        memberController.changeEmail(member);
        createSpecificMemberMenu(member);
        break;
      case BACK:
        createSpecificMemberMenu(member);
    }
  }

  public void createSpecificItemMenu(Item item, Member member) {
    switch (view.printSpecificItemMenu()) {
      case CHANGE_NAME:
        itemController.changeName(item);
        createSpecificItemMenu(item, member);
        break;
      case CHANGE_CATEGORY:
        itemController.changeCategory(item);
        createSpecificItemMenu(item, member);
        break;
      case CHANGE_DESCRIPTION:
        itemController.changeDescription(item);
        createSpecificItemMenu(item, member);
        break;
      case CHANGE_COST:
        itemController.changeCost(item);
        createSpecificItemMenu(item, member);
        break;
      case DELETE_ITEM:
        memberController.deleteItem(item, member);
        createSpecificMemberMenu(member);
        break;
      case BACK:
        createSpecificMemberMenu(member);
    }
  }
}
