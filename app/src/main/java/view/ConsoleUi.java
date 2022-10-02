package view;

import java.util.Scanner;

public class ConsoleUi {
  private Scanner scan;

  public ConsoleUi() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  public String getInput() {
    return scan.nextLine();
  }

  public String printMainMenu() {
    System.out.println("1. Create a member");
    System.out.println("2. Select a specific member");
    System.out.println("3. Show members");
    System.out.println("4. Advance 1 day");
    return getInput();
  }

  public String printSpecificMemberMenu() {
    System.out.println("1. Show information");
    System.out.println("2. Change Information");
    System.out.println("3. Create a new item");
    System.out.println("4. Select an item");
    System.out.println("5. Create new contract");
    System.out.println("6. Delete this member");
    return getInput();
  }

  public String printShowAllMembersMenu() {
    System.out.println("1. Show in a simple way");
    System.out.println("2. Show in a verbose way");
    return getInput();
  }


}
