package model;

import java.util.ArrayList;

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

  public Item(String category, String name, String description, int createdAtDay, int costPerDay, boolean availableForLoan) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.createdAtDay = createdAtDay;
    this.costPerDay = costPerDay;
    this.availableForLoan = availableForLoan;
    this.contracts = new ArrayList<Contract>();
  }

  public boolean getAvailableForLoan() {
    return availableForLoan;
  }

  public int getCurrentContractEndDay() {
    return currentContractEndDay;
  }

  public void setCurrentContractEndDay(int currentContractEndDay) {
    this.currentContractEndDay = currentContractEndDay;
  }

  public void setCurrentContractStartDay(int currentContractStartDay) {
    this.currentContractStartDay = currentContractStartDay;
  }

  public int getCurrentContractStartDay() {
    return currentContractStartDay;
  }

  public void setCurrentlyLentTo(String currentlyLentTo) {
    this.currentlyLentTo = currentlyLentTo;
  }

  public String getCurrentlyLentTo() {
      return currentlyLentTo;
  }

  public boolean getAvailableBetweenDays(int startDay, int endDay) {
    boolean checkEachContract = true;
    for (Contract contract : contracts) {
      if ((startDay >= contract.getStartDay() && startDay <= contract.getEndDay()) || (endDay >= contract.getStartDay() && endDay <= contract.getEndDay())) {
        checkEachContract = false;
      }
    }
    return checkEachContract;
  }

  public void makeItemAvailable() {
    this.availableForLoan = true;
  }

  public void makeItemUnavailable() {
    this.availableForLoan = false;
  }

  public ArrayList<Contract> getContracts() {
      return contracts;
  }

  public void addContract(Contract contract) {
    this.contracts.add(contract);
  }

  public String getCategory() {
      return category;
  }

  public void setCategory(String category) {
      this.category = category;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getDescription() {
      return description;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public int getCreatedAtDay() {
      return createdAtDay;
  }

  public void setCreatedAtDay(int createdAtDay) {
      this.createdAtDay = createdAtDay;
  }

  public int getCostPerDay() {
      return costPerDay;
  }

  public void setCostPerDay(int costPerDay) {
      this.costPerDay = costPerDay;
  }
}
