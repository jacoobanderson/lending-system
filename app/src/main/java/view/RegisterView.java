package view;

import java.util.Scanner;

/**
 * The register view.
 */
public class RegisterView {
  private Scanner scan;

  /**
   * The constructor.
   */
  public RegisterView() {
    this.scan = new Scanner(System.in, "utf-8");
  }

  /**
   * Prints the first name question.
   *
   * @return The input.
   */
  public String showFirstNameQuestion() {
    System.out.println("What is your first name?");
    return scan.nextLine();
  }

  /**
   * Prints the last name question.
   *
   * @return The input.
   */
  public String showLastNameQuestion() {
    System.out.println("What is your last name?");
    return scan.nextLine();
  }

  /**
   * Prints the phone number question.
   *
   * @return The input.
   */
  public String showPhoneNumberQuestion() {
    System.out.println("What is your phone number?");
    return scan.nextLine();
  }

  /**
   * Prints the email question.
   *
   * @return The input.
   */
  public String showEmailQuestion() {
    System.out.println("What is your email?");
    return scan.nextLine();
  }

  /**
   * Prints the specific member email question.
   *
   * @return The input.
   */
  public String showMemberEmailQuestion() {
    System.out.println("What is the email of the specific member?");
    return scan.nextLine();
  }

  /**
   * Prints the simple version of member.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param email The email.
   * @param credits The credits.
   * @param numberOfItems The number of items.
   */
  public void printMemberSimple(String firstName, String lastName, String email, int credits, int numberOfItems) {
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Email: " + email);
    System.out.println("Credits: " + credits);
    System.out.println("Number of items: " + numberOfItems + "\n");
  }

  /**
   * Prints the verbose version of member information.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param email The email.
   * @param credits The credits.
   */
  public void printMemberVerbose(String firstName, String lastName, String email, int credits, String id) {
    System.out.println("ID: " + id);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Email: " + email);
    System.out.println("Credits: " + credits);
    System.out.println("Items: \n");
  }
}
