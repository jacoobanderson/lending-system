package controller;

import model.Member;
import view.ConsoleUi;

public class MainController {
  private ConsoleUi view;
  private MemberRegisterController registerController;
  private MemberController memberController;

  public MainController(ConsoleUi view, MemberRegisterController registerController, MemberController memberController) {
    this.view = view;
    this.registerController = registerController;
    this.memberController = memberController;
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

        break;
      case CREATE_ITEM:
        memberController.createItem(member);
        createSpecificMemberMenu(member);
        break;
      case SELECT_ITEM:

        break;
      case CREATE_CONTRACT:

        break;
      case DELETE_MEMBER:
        registerController.deleteMember(member);
        createMainMenu();
        break;
      case BACK:
        createMainMenu();
    }
  }
}
