package controller;

import model.MemberRegister;
import view.ConsoleUi;
import view.ItemView;
import view.MemberView;
import view.RegisterView;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {

    ConsoleUi view = new ConsoleUi();

    MemberView memberView = new MemberView();
    MemberRegister memberRegister = new MemberRegister();
    MemberController memberController = new MemberController(memberView, memberRegister);

    RegisterView registerView = new RegisterView();

    ItemView itemView = new ItemView();
    ItemController itemController = new ItemController(itemView, memberRegister);
    MemberRegisterController register = new MemberRegisterController(memberRegister, registerView, memberController);
    Time time = new Time(0, memberRegister, itemController, memberController, register);

    MainController mainController = new MainController(view, register, memberController, itemController, time);
    mainController.start();
  }
}