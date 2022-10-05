package view;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterView {
  private Scanner scan;

  public RegisterView() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  public String showFirstNameQuestion() {
    System.out.println("What is your first name?");
    return scan.nextLine();
  }

  public String showLastNameQuestion() {
    System.out.println("What is your last name?");
    return scan.nextLine();
  }

  public String showPhoneNumberQuestion() {
    System.out.println("What is your phone number?");
    return scan.nextLine();
  }

  public String showEmailQuestion() {
    System.out.println("What is your email?");
    return scan.nextLine();
  }

  public String showMemberEmailQuestion() {
    System.out.println("What is the email of the specific member?");
    return scan.nextLine();
  }

  public void printMemberSimple(String firstName, String lastName, String email, int credits, int numberOfItems) {
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Email: " + email);
    System.out.println("Credits: " + credits);
    System.out.println("Number of items: " + numberOfItems + "\n");
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
