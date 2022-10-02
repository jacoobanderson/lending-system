package controller;

import model.Member;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    model.Member member = new Member("Jacob Andersson", "j00cwa@gmail.com", "0763910384");

    System.out.println(member.getUniqueId());
    System.out.println(member.getName());
    System.out.println(member.getEmail());
    System.out.println(member.getPhoneNumber());

    member.createItem("Tool", "Hammer", "A hammer", 0, 20);
    member.createItem("Game", "WOW", "A computer game", 0, 40);
    
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