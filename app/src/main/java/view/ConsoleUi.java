package view;

import java.util.Scanner;

public class ConsoleUi {
  private Scanner scan;

  public ConsoleUi() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  public void closeScanner() {
    scan.close();
  }

  public MainMenuEvent printMainMenu() {
    System.out.println("1. Create a member");
    System.out.println("2. Select a specific member");
    System.out.println("3. Show in a simple way");
    System.out.println("4. Show in a verbose way");
    System.out.println("5. Advance 1 day \n");
    System.out.println("To exit the application enter 0.");
    return getMainMenuInput();
  }

  public void printSpecificMemberMenu() {
    System.out.println("1. Show information");
    System.out.println("2. Change Information");
    System.out.println("3. Create a new item");
    System.out.println("4. Select an item");
    System.out.println("5. Create new contract");
    System.out.println("6. Delete this member");
    System.out.println("To go back to the main menu enter 0.");
  }

  public MainMenuEvent getMainMenuInput() {
    switch(scan.nextInt()) {
      case 1:
        return MainMenuEvent.CREATE_MEMBER;
      case 2:
        return MainMenuEvent.SELECT_SPECIFIC_MEMBER;
      case 3:
        return MainMenuEvent.SHOW_SIMPLE_WAY;
      case 4:
        return MainMenuEvent.SHOW_VERBOSE_WAY;
      case 5:
        return MainMenuEvent.ADVANCE_ONE_DAY;
      default:
        return MainMenuEvent.QUIT;
    }
  }

  public SpecificMemberEvent getSpecificMemberMenuInput() {
    switch(scan.nextInt()) {
      case 1:
        return SpecificMemberEvent.SHOW_INFORMATION;
      case 2:
        return SpecificMemberEvent.CHANGE_INFORMATION;
      case 3:
        return SpecificMemberEvent.CREATE_ITEM;
      case 4:
        return SpecificMemberEvent.SELECT_ITEM;
      case 5:
        return SpecificMemberEvent.CREATE_CONTRACT;
      case 6:
        return SpecificMemberEvent.DELETE_MEMBER;
      default:
        return SpecificMemberEvent.BACK;
    }
  }

  public enum MainMenuEvent {
    CREATE_MEMBER,
    SELECT_SPECIFIC_MEMBER,
    SHOW_SIMPLE_WAY,
    SHOW_VERBOSE_WAY,
    ADVANCE_ONE_DAY,
    QUIT
  }

  public enum SpecificMemberEvent {
    SHOW_INFORMATION,
    CHANGE_INFORMATION,
    CREATE_ITEM,
    SELECT_ITEM,
    CREATE_CONTRACT,
    DELETE_MEMBER,
    BACK
  }

}
