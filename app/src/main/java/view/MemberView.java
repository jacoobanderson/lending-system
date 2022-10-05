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

}
