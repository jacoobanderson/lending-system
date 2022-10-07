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
}
