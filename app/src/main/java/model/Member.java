package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type member.
 */
public class Member {
  private String uniqueId;
  private String name;
  private String email;
  private String phoneNumber;
  private int createdAtDay;
  private ArrayList<Item> itemList;
  private int credits;

  /**
   * Instantiates a new member.
   *
   * @param name   The first name.
   * @param lastName    The last name.
   * @param email       The email.
   * @param phoneNumber The phone number.
   */
  public Member(String name, String email, String phoneNumber) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.uniqueId = generateId();
    this.itemList = new ArrayList<Item>();
  }


  /**
   * Gets the credits.
   *
   * @return The credits.
   */
  public int getCredits() {
      return credits;
  }


  /**
   * Adds credits.
   *
   * @return The credits.
   */
  public void addCredits(int credits) {
      this.credits += credits;
  }

  /**
   * Gets the unique id.
   *
   * @return The unique id.
   */
  public String getUniqueId() {
    return uniqueId;
  }

  /**
   * Gets the first name.
   *
   * @return The first name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the first name.
   *
   * @param name The first name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the email.
   *
   * @return The email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email The email.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the phone number.
   *
   * @return The phone number.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Sets the phone number.
   *
   * @param phoneNumber The phone number.
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  private String generateId() {
    Random random = new Random();
    String UpperCaseletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    String id = "";
    int idLengthDividedByTwo = 3;

    for (int i = 0; i < idLengthDividedByTwo; i++) {
      int capitalLetterOrNot = random.nextInt(2);
      int randomLetter = random.nextInt(26);
      int randomNumber = random.nextInt(9);

      if (capitalLetterOrNot == 1) {
        id += UpperCaseletters.charAt(randomLetter);
      } else {
        id += lowerCaseLetters.charAt(randomLetter);
      }

      id += numbers.charAt(randomNumber);
    }
    return id;
  }

  public void createItem(String category, String name, String description, int createdAtDay, int costPerDay) {
    Item item = new Item(category, name, description, createdAtDay, costPerDay);
    itemList.add(item);
    addCredits(100);
  }

  public ArrayList<Item> getItems() {
    return this.itemList;
  }

  public Item findItemByName(String name) {
    for (Item item : this.itemList) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  public void deleteItem(Item item) {
    this.itemList.remove(item);
  }
}
