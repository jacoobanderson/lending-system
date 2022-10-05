package view;

import java.util.Scanner;

public class MemberView {
  private Scanner scan;

  public MemberView() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  public void printMemberFullInformation(String id, String firstName, String lastName, String email, int credits, int day) {
    System.out.println("ID: " + id);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Email: " + email);
    System.out.println("Credits: " + credits);
    // ++ items
    System.out.println("Created at day: " + day  + "\n");
  }

  // String category, String name, String description, int createdAtDay, int costPerDay
  public String showItemCategoryQuestion() {
    System.out.println("What's the category of the item? (Tool, Vehicle, Game, Toy, Sport or Other)");
    return scan.nextLine();
  }

  public String showItemNameQuestion() {
    System.out.println("What's the name of the item?");
    return scan.nextLine();
  }

  public String showItemDescriptionQuestion() {
    System.out.println("What's the description of the item?");
    return scan.nextLine();
  }

  public int showItemCostQuestion() {
    System.out.println("What's the cost of the item per day?");
    return scan.nextInt();
  }

  // Add more contract to who etc...
  public void printMemberItemVerbose(String category, String name, String description, int cost) {
    System.out.println("Category: " + category);
    System.out.println("Name: " + name);
    System.out.println("Description: " + description);
    System.out.println("Cost per day: " + cost + "\n");
  }

}
