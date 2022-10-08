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

  public SpecificMemberEvent printSpecificMemberMenu() {
    System.out.println("1. Show information");
    System.out.println("2. Change Information");
    System.out.println("3. Create a new item");
    System.out.println("4. Select an item");
    System.out.println("5. Create new contract");
    System.out.println("6. Delete this member");
    System.out.println("To go back to the main menu enter 0.");
    return getSpecificMemberMenuInput();
  }

  public SpecificItemEvent printSpecificItemMenu() {
    System.out.println("1. Change name");
    System.out.println("2. Change category");
    System.out.println("3. Change description");
    System.out.println("4. Change cost per day");
    System.out.println("5. View contracts");
    System.out.println("6. Delete this item");
    System.out.println("To go back to the member menu enter 0.");
    return getSpecificItemMenuInput();
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

  public SpecificItemEvent getSpecificItemMenuInput() {
    switch(scan.nextInt()) {
      case 1:
        return SpecificItemEvent.CHANGE_NAME;
      case 2:
        return SpecificItemEvent.CHANGE_CATEGORY;
      case 3:
        return SpecificItemEvent.CHANGE_DESCRIPTION;
      case 4:
        return SpecificItemEvent.CHANGE_COST;
      case 5:
        return SpecificItemEvent.VIEW_CONTRACTS;
      case 6:
        return SpecificItemEvent.DELETE_ITEM;
      default:
        return SpecificItemEvent.BACK;
    }
  }

  public ChangeInformationEvent printChangeInformationMenu() {
    System.out.println("1. Change first name");
    System.out.println("2. Change last name");
    System.out.println("3. Change email");
    System.out.println("To go back to the member menu enter 0.");
    return getChangeInformationInput();
  }

  public ChangeInformationEvent getChangeInformationInput() {
    switch (scan.nextInt()) {
      case 1:
        return ChangeInformationEvent.CHANGE_FIRST_NAME;
      case 2:
        return ChangeInformationEvent.CHANGE_LAST_NAME;
      case 3:
        return ChangeInformationEvent.CHANGE_EMAIL;
      default:
        return ChangeInformationEvent.BACK;
    }
  }

  public enum ChangeInformationEvent {
    CHANGE_FIRST_NAME,
    CHANGE_LAST_NAME,
    CHANGE_EMAIL,
    BACK
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

  public enum SpecificItemEvent {
    CHANGE_NAME,
    CHANGE_CATEGORY,
    CHANGE_DESCRIPTION,
    CHANGE_COST,
    VIEW_CONTRACTS,
    DELETE_ITEM,
    BACK
  }
}
