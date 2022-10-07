package model;

import java.util.ArrayList;

/**
 * The type member.
 */
public class Member {
  private String uniqueId;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private int createdAtDay;
  private ArrayList<Item> itemList;
  private int credits;

  /**
   * Instantiates a new member.
   *
   * @param firstName   The first firstName.
   * @param lastfirstName    The last firstName.
   * @param email       The email.
   * @param phoneNumber The phone number.
   */
  public Member(String firstName, String lastName, String email, String phoneNumber, int createdAtDay, String uniqueId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.createdAtDay = createdAtDay;
    this.uniqueId = uniqueId;
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

  public void subtractCredits(int credits) {
    this.credits -= credits;
  }

  /**
   * Gets the day the member was created.
   *
   * @return The day.
   */
  public int getCreatedAtDay() {
      return createdAtDay;
  }

  /**
   * Sets the day the member was created.
   *
   * @return The day.
   */
  public void setCreatedAtDay(int createdAtDay) {
      this.createdAtDay = createdAtDay;
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
   * Sets the unique id.
   *
   * @return The unique id.
   */
  public void setUniqueId(String uniqueId) {
      this.uniqueId = uniqueId;
  }

  /**
   * Gets the first first name.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name.
   *
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name.
   *
   * @param firstName The last name.
   */
  public String getLastName() {
      return lastName;
  }

  /**
   * Sets the last name.
   *
   * @param firstName The last name.
   */
  public void setLastName(String lastName) {
      this.lastName = lastName;
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

  public void createItem(String category, String name, String description, int createdAtDay, int costPerDay) {
    Item item = new Item(category, name, description, createdAtDay, costPerDay);
    itemList.add(item);
    addCredits(100);
  }

  public void addItem(Item item) {
    itemList.add(item);
  }

  public ArrayList<Item> getItems() {
    return this.itemList;
  }

  public Item findItemByName(String itemName) {
    for (Item item : this.itemList) {
      if (item.getName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }

  public void deleteItem(Item item) {
    // shouldnt delete if the item is in contract?
    this.itemList.remove(item);
  }
}
