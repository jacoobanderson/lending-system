package view;

import java.util.Scanner;

public class ItemView {
  private Scanner scan;

  public ItemView() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  public String changeItemNameQuestion() {
    System.out.println("What would you like to change the item name to?");
    return scan.nextLine();
  }

  public String changeItemCategoryQuestion() {
    System.out.println("What would you like to change the item category to? (Tool, Vehicle, Game, Toy, Sport or Other)");
    return scan.nextLine();
  }

  public String changeItemDescriptionQuestion() {
    System.out.println("What would you like to change the item description to?");
    return scan.nextLine();
  }

  public int changeItemCostQuestion() {
    System.out.println("What would you like to change the item cost per day to?");
    return scan.nextInt();
  }

  public String contractMemberQuestion() {
    System.out.println("Please enter the email of the member you wish to lend the item to");
    return scan.nextLine();
  }

  public int contractStartDayQuestion() {
    System.out.println("What day do you wish the contract to start on?");
    return scan.nextInt();
  }

  public int contractEndDayQuestion() {
    System.out.println("What day do you wish the contract to end on?");
    return scan.nextInt();
  }

  public void viewContract(int startDay, int endDay, String lenderEmail) {
    System.out.println("\nStart day: " + startDay);
    System.out.println("End day: " + endDay);
    System.out.println("Lended to (Email): " + lenderEmail + "\n");
  }
}
