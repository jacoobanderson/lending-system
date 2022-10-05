package controller;

import view.ConsoleUi;

public class MainController {
  private ConsoleUi view;
  private MemberRegisterController registerController;

  public MainController(ConsoleUi view, MemberRegisterController registerController) {
    this.view = view;
    this.registerController = registerController;
  }

  public void start() {
    createMainMenu();
  }
  
  public void createMainMenu() {
    switch (view.printMainMenu()) {
      case CREATE_MEMBER:
          // memberregister
        break;
      case SELECT_SPECIFIC_MEMBER:

        break;
      case SHOW_SIMPLE_WAY:

        break;
      case SHOW_VERBOSE_WAY:

        break;
      case ADVANCE_ONE_DAY:

        break;
      default:
        
        break;
    }
  }
}
