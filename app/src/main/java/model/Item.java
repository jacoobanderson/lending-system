package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type item.
 */
public class Item {
  private String category;
  private String name;
  private String description;
  private int createdAtDay;
  private int costPerDay;
  private boolean availableForLoan;
  private ArrayList<Contract> contracts;
  private String currentlyLentTo;
  private int currentContractStartDay;
  private int currentContractEndDay;

  /**
   * The constructor.
   *
   * @param category         The category.
   * @param name             The name.
   * @param description      The description of the item.
   * @param createdAtDay     The day created.
   * @param costPerDay       The cost per day.
   * @param availableForLoan If it is available or not.
   */
  public Item(String category, String name, String description, int createdAtDay, int costPerDay,
      boolean availableForLoan) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.createdAtDay = createdAtDay;
    this.costPerDay = costPerDay;
    this.availableForLoan = availableForLoan;
    this.contracts = new ArrayList<Contract>();
  }

  /**
   * Checks if it is available or not.
   *
   * @return if available.
   */
  public boolean getAvailableForLoan() {
    return availableForLoan;
  }

  /**
   * Gets the current end day of a contract.
   *
   * @return The end day.
   */
  public int getCurrentContractEndDay() {
    return currentContractEndDay;
  }

  /**
   * Sets the current end day of contract.
   *
   * @param currentContractEndDay The current end day.
   */
  public void setCurrentContractEndDay(int currentContractEndDay) {
    this.currentContractEndDay = currentContractEndDay;
  }

  /**
   * Sets the current contracts start day.
   *
   * @param currentContractStartDay The current start day.
   */
  public void setCurrentContractStartDay(int currentContractStartDay) {
    this.currentContractStartDay = currentContractStartDay;
  }

  /**
   * Gets the current contracts start day.
   *
   * @return The current contracts start day.
   */
  public int getCurrentContractStartDay() {
    return currentContractStartDay;
  }

  /**
   * Sets currently lent to.
   *
   * @param currentlyLentTo The email of who it is currently lent to.
   */
  public void setCurrentlyLentTo(String currentlyLentTo) {
    this.currentlyLentTo = currentlyLentTo;
  }

  /**
   * Gets the email of who it is currently lent to.
   *
   * @return The email of who it is currently lent to.
   */
  public String getCurrentlyLentTo() {
    return currentlyLentTo;
  }

  /**
   * Decides if it is available between days.
   *
   * @param startDay The start day.
   * @param endDay   The end day.
   * @return If it is available between these days or not.
   */
  public boolean getAvailableBetweenDays(int startDay, int endDay) {
    boolean checkEachContract = true;
    for (Contract contract : contracts) {
      if ((startDay >= contract.getStartDay() && startDay <= contract.getEndDay())
          || (endDay >= contract.getStartDay() && endDay <= contract.getEndDay())) {
        checkEachContract = false;
      }
    }
    return checkEachContract;
  }

  /**
   * Sets the item to available.
   */
  public void makeItemAvailable() {
    this.availableForLoan = true;
  }

  /**
   * Sets the item to unavailable.
   */
  public void makeItemUnavailable() {
    this.availableForLoan = false;
  }

  /**
   * Gets the contracts.
   *
   * @return The contracts.
   */
  public List<Contract> getContracts() {
    List<Contract> unmodifiableList = Collections.unmodifiableList(contracts);
    return unmodifiableList;
  }

  /**
   * Adds a contract.
   *
   * @param contract The contract.
   */
  public void addContract(Contract contract) {
    this.contracts.add(contract);
  }

  /**
   * Gets the category.
   *
   * @return the category.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets the category.
   *
   * @param category The category.
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Gets the name.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name The name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the description.
   *
   * @return The description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description The description.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the day created at.
   *
   * @return The day created.
   */
  public int getCreatedAtDay() {
    return createdAtDay;
  }

  /**
   * Sets the day created at.
   *
   * @param createdAtDay The day created at.
   */
  public void setCreatedAtDay(int createdAtDay) {
    this.createdAtDay = createdAtDay;
  }

  /**
   * Gets the cost per day.
   *
   * @return The cost per day.
   */
  public int getCostPerDay() {
    return costPerDay;
  }

  /**
   * Sets the cost per day.
   *
   * @param costPerDay The cost per day.
   */
  public void setCostPerDay(int costPerDay) {
    this.costPerDay = costPerDay;
  }
}
