package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import model.Item;
import model.Member;
import view.ConsoleUi;

/**
 * The main controller.
 */
public class MainController {
  private ConsoleUi view;
  private MemberRegisterController registerController;
  private MemberController memberController;
  private ItemController itemController;
  private Time time;

  /**
   * The constructor.
   *
   * @param view               The console ui.
   * @param registerController The register controller.
   * @param memberController   The member controller.
   * @param itemController     The item controller.
   * @param time               The item.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Main controller needs access.")
  public MainController(ConsoleUi view, MemberRegisterController registerController,
      MemberController memberController,
      ItemController itemController, Time time) {
    this.view = view;
    this.registerController = registerController;
    this.memberController = memberController;
    this.itemController = itemController;
    this.time = time;
  }

  /**
   * Starts the application.
   */
  public void start() {
    try {
      createMainMenu();
    } catch (Exception e) {
      System.out.println("Something went wrong!");
      createMainMenu();
    }
  }

  /**
   * Creates the main menu.
   */
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
      default:
        break;
    }
  }

  /**
   * Creates the specific member menu.
   *
   * @param member The member.
   */
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
        break;
      default:
        break;
    }
  }

  /**
   * Creates the change member information menu.
   *
   * @param member The member.
   */
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
        break;
      default:
        break;
    }
  }

  /**
   * Creates the specific item menu.
   *
   * @param item   The item.
   * @param member The member.
   */
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
      case VIEW_CONTRACTS:
        itemController.showContracts(item);
        createSpecificItemMenu(item, member);
        break;
      case DELETE_ITEM:
        memberController.deleteItem(item, member);
        createSpecificMemberMenu(member);
        break;
      case BACK:
        createSpecificMemberMenu(member);
        break;
      default:
        break;
    }
  }
}
