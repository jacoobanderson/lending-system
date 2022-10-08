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

   * @param args command line arguments.
   */
  public static void main(String[] args) {
   
    ConsoleUi view = new ConsoleUi();

    MemberView memberView = new MemberView();
    MemberController memberController = new MemberController(memberView);

    RegisterView registerView = new RegisterView();

    ItemView itemView = new ItemView();
    MemberRegister memberRegister = new MemberRegister();
    ItemController itemController = new ItemController(itemView, memberRegister);
    MemberRegisterController register = new MemberRegisterController(memberRegister, registerView, memberController);
    
    Time time = new Time(0, memberRegister, itemController, memberController, register);
    MainController mainController = new MainController(view, register, memberController, itemController, time);

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