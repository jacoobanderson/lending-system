package view;

import java.util.Scanner;

/**
 * The member view.
 */
public class MemberView {
  private Scanner scan;

  /**
   * The constructor.
   */
  public MemberView() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  /**
   * Prints the member full information.
   *
   * @param id        The id.
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param email     The email.
   * @param credits   The credits.
   * @param day       THe day.
   */
  public void printMemberFullInformation(String id, String firstName, String lastName, String email, int credits,
      int day) {
    System.out.println("ID: " + id);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Email: " + email);
    System.out.println("Credits: " + credits);
    System.out.println("Created at day: " + day + "\n");
  }

  /**
   * Prints the item category question.
   *
   * @return The input.
   */
  public String showItemCategoryQuestion() {
    System.out.println("What's the category of the item? (Tool, Vehicle, Game, Toy, Sport or Other)");
    return scan.nextLine();
  }

  /**
   * Prints the item name question.
   *
   * @return The input.
   */
  public String showItemNameQuestion() {
    System.out.println("What's the name of the item?");
    return scan.nextLine();
  }

  /**
   * Prints the description of item question.
   *
   * @return The input.
   */
  public String showItemDescriptionQuestion() {
    System.out.println("What's the description of the item?");
    return scan.nextLine();
  }

  /**
   * Prints the cost of item question.
   *
   * @return The input.
   */
  public int showItemCostQuestion() {
    System.out.println("What's the cost of the item per day?");
    int input = scan.nextInt();
    scan.nextLine();
    return input;
  }

  /**
   * Prints the member item information in verbose form.
   *
   * @param category        The category.
   * @param name            The name.
   * @param description     The description.
   * @param cost            The cost.
   * @param currentlyLentTo The email of who it is currently lent to.
   * @param startDay        The start day of contract.
   * @param endDay          The end day of contract.
   */
  public void printMemberItemVerbose(String category, String name, String description, int cost, String currentlyLentTo,
      int startDay, int endDay) {
    System.out.println("Category: " + category);
    System.out.println("Name: " + name);
    System.out.println("Description: " + description);
    System.out.println("Cost per day: " + cost);
    System.out.println("Currently lent to: " + currentlyLentTo);
    System.out.println("Lent from day: " + startDay);
    System.out.println("Lent to day: " + endDay + "\n");
  }

  /**
   * Prints the change first name question.
   *
   * @return The input.
   */
  public String changeFirstNameQuestion() {
    System.out.println("What would you like to change the first name to?");
    return scan.nextLine();
  }

  /**
   * Prints the change last name question.
   *
   * @return The input.
   */
  public String changeLastNameQuestion() {
    System.out.println("What would you like to change the last name to?");
    return scan.nextLine();
  }

  /**
   * Prints the change email question.
   *
   * @return The input.
   */
  public String changeEmailQuestion() {
    System.out.println("What would you like to change email to?");
    return scan.nextLine();
  }

  /**
   * Prints the select item question.
   *
   * @return The input.
   */
  public int selectItemQuestion() {
    System.out.println("Which item do you wish to select?");
    int input = scan.nextInt();
    scan.nextLine();
    return input;
  }

  /**
   * Prints the item number.
   *
   * @param number The number of the item.
   */
  public void printItemNumber(int number) {
    System.out.println("Item " + number + ":");
  }
}
