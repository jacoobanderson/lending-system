package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
   * @param firstName     The first firstName.
   * @param lastName The last firstName.
   * @param email         The email.
   * @param phoneNumber   The phone number.
   */
  public Member(String firstName, String lastName, String email, String phoneNumber, int createdAtDay,
      String uniqueId) {
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
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName The last name.
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

  /**
   * Creates an item.
   *
   * @param category The category.
   * @param name The name.
   * @param description The description.
   * @param createdAtDay The creation day.
   * @param costPerDay The cost per day.
   */
  public void createItem(String category, String name, String description, int createdAtDay, int costPerDay) {
    Item item = new Item(category, name, description, createdAtDay, costPerDay, true);
    itemList.add(item);
    addCredits(100);
  }

  /**
   * Adds an item to the item list.
   *
   * @param item The item.
   */
  public void addItem(Item item) {
    itemList.add(item);
  }

  /**
   * Gets the items.
   *
   * @return The items.
   */
  public List<Item> getItems() {
    List<Item> unmodifiableList = Collections.unmodifiableList(itemList);
    return unmodifiableList;
  }

  /**
   * Finds an item by name.
   *
   * @param itemName The name of the item.
   * @return The item.
   */
  public Item findItemByName(String itemName) {
    for (Item item : this.itemList) {
      if (item.getName().equals(itemName)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Deletes an item.
   *
   * @param item The item.
   */
  public void deleteItem(Item item) {
    this.itemList.remove(item);
  }

  /**
   * Checks if the member has enough credits.
   *
   * @param credits The credits.
   * @return True or false.
   */
  public boolean hasEnoughCredits(int credits) {
    if (this.credits >= credits) {
      return true;
    }
    return false;
  }
}


