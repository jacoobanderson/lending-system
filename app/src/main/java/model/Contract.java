package model;

/**
 * The type contract.
 */
public class Contract {
  private Item item;
  private int startDay;
  private int endDay;
  private String ownerEmail;
  private String lenderEmail;
    
  /**
   * The constructor.
   *
   * @param item The item.
   * @param startDay The start day of the contract.
   * @param endDay The end day of the contract.
   * @param ownerEmail The email of the owner of the item.
   * @param lenderEmail The email of the lender.
   */
  public Contract(Item item, int startDay, int endDay, String ownerEmail, String lenderEmail) {
    this.item = item;
    this.startDay = startDay;
    this.endDay = endDay;
    this.ownerEmail = ownerEmail;
    this.lenderEmail = lenderEmail;
  }

  /**
   * Gets the lenders email.
   *
   * @return The email of the lender.
   */
  public String getLenderEmail() {
    return lenderEmail;
  }

  /**
   * Sets the lenders email.
   *
   * @param lenderEmail The lenders email.
   */
  public void setLenderEmail(String lenderEmail) {
    this.lenderEmail = lenderEmail;
  }

  /**
   * Gets the email of the owner.
   *
   * @return The email of the owner.
   */
  public String getOwnerEmail() {
    return ownerEmail;
  }

  /**
   * Sets the email of the owner.
   *
   * @param ownerEmail The email of the owner.
   */
  public void setOwnerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
  }

  /**
   * Gets the total cost of the contract.
   *
   * @return The total cost.
   */
  public int getTotalCost() {
    int amountOfDays = endDay - startDay + 1;
    int cost = item.getCostPerDay() * amountOfDays;
    return cost;
  }

  /**
   * Gets the end day of the contract.
   *
   * @return The end day.
   */
  public int getEndDay() {
    return endDay;
  }

  /**
   * Sets the end day of the contract.
   *
   * @param endDay The end day.
   */
  public void setEndDay(int endDay) {
    this.endDay = endDay;
  }

  /**
   * Gets the item.
   *
   * @return The item.
   */
  public Item getItem() {
    return item;
  }

  /**
   * Sets the item.
   *
   * @param item The item.
   */
  public void setItem(Item item) {
    this.item = item;
  }

  /**
   * Gets the start day.
   *
   * @return The start day.
   */
  public int getStartDay() {
    return startDay;
  }

  /**
   * Sets the start day.
   *
   * @param startDay The start day.
   */
  public void setStartDay(int startDay) {
    this.startDay = startDay;
  }
}
