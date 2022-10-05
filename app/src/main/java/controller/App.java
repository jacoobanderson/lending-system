package controller;

import model.Item;
import model.Member;
import model.MemberRegister;
import view.ConsoleUi;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {

    ConsoleUi view = new ConsoleUi();
    MemberRegisterController register = new MemberRegisterController();
    MainController mainController = new MainController(view, register);
    mainController.start();


    // adapt to start the application in your way
    // model.Simple m = new model.Simple();
    // Simple c = new Simple();
    // view.Simple v = new view.Simple();

    // c.doSomethingSimple(m, v);
  }
}


// Controller Next file
// public void doSomethingSimple(model.Simple m, view.Simple v) {
//   v.showMessage(m.getMessage());
// }