package view;

import java.util.Scanner;

public class ConsoleUi {
  private Scanner scan;

  public ConsoleUi() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  public String printMainMenu() {
    System.out.println("1. Create a member");
    System.out.println("2. Select a specific member");
    System.out.println("3. Show in a simple way");
    System.out.println("4. Show in a verbose way");
    System.out.println("5. Advance 1 day");
  }

  public String printSpecificMemberMenu() {
    System.out.println("1. Show information");
    System.out.println("2. Change Information");
    System.out.println("3. Create a new item");
    System.out.println("4. Select an item");
    System.out.println("5. Create new contract");
    System.out.println("6. Delete this member");
  }

  public 

  public enum MainMenuEvent {
    CREATE_MEMBER,
    SELECT_SPECIFIC_MEMBER,
    SHOW_SIMPLE_WAY,
    SHOW_VERBOSE_WAY,
    ADVANCE_ONE_DAY
  }

  public enum SpecificMemberEvent {
    SHOW_INFORMATION,
    CHANGE_INFORMATION,
    CREATE_ITEM,
    SELECT_ITEM,
    CREATE_CONTRACT,
    DELETE_MEMBER
  }

}
