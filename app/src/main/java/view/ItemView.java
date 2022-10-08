package view;

import java.util.Scanner;

/**
 * The item view.
 */
public class ItemView {
  private Scanner scan;

  /**
   * The constructor.
   */
  public ItemView() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  /**
   * Prints the change item name question.
   *
   * @return The input.
   */
  public String changeItemNameQuestion() {
    System.out.println("What would you like to change the item name to?");
    return scan.nextLine();
  }

  /**
   * Prints the change item category question.
   *
   * @return The input.
   */
  public String changeItemCategoryQuestion() {
    System.out
        .println("What would you like to change the item category to? (Tool, Vehicle, Game, Toy, Sport or Other)");
    return scan.nextLine();
  }

  /**
   * Prints the change item description question.
   *
   * @return The input.
   */
  public String changeItemDescriptionQuestion() {
    System.out.println("What would you like to change the item description to?");
    return scan.nextLine();
  }

  /**
   * Prints the change item cost question.
   *
   * @return The input.
   */
  public int changeItemCostQuestion() {
    System.out.println("What would you like to change the item cost per day to?");
    int input = scan.nextInt();
    scan.nextLine();
    return input;
  }

  /**
   * Prints the contract member question.
   *
   * @return The input.
   */
  public String contractMemberQuestion() {
    System.out.println("Please enter the email of the member you wish to lend the item to");
    return scan.nextLine();
  }

  /**
   * Prints the start day question.
   *
   * @return The input.
   */
  public int contractStartDayQuestion() {
    System.out.println("What day do you wish the contract to start on?");
    int input = scan.nextInt();
    scan.nextLine();
    return input;
  }

  /**
   * Prints the contract end day question.
   *
   * @return The input.
   */
  public int contractEndDayQuestion() {
    System.out.println("What day do you wish the contract to end on?");
    int input = scan.nextInt();
    scan.nextLine();
    return input;
  }

  /**
   * Prints the contract view.
   *
   * @param startDay    The start day.
   * @param endDay      The end day.
   * @param lenderEmail the email of the lender.
   */
  public void viewContract(int startDay, int endDay, String lenderEmail) {
    System.out.println("\nStart day: " + startDay);
    System.out.println("End day: " + endDay);
    System.out.println("Lended to (Email): " + lenderEmail + "\n");
  }
}
