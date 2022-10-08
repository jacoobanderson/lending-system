package model;

public class Contract {
  private Item item;
  private int startDay;
  private int endDay;
  private String ownerEmail;
  private String lenderEmail;
    
  public Contract(Item item, int startDay, int endDay, String ownerEmail, String lenderEmail) {
    this.item = item;
    this.startDay = startDay;
    this.endDay = endDay;
    this.ownerEmail = ownerEmail;
    this.lenderEmail = lenderEmail;
  }

  public String getLenderEmail() {
      return lenderEmail;
  }

  public void setLenderEmail(String lenderEmail) {
      this.lenderEmail = lenderEmail;
  }

  public String getOwnerEmail() {
      return ownerEmail;
  }

  public void setOwnerEmail(String ownerEmail) {
      this.ownerEmail = ownerEmail;
  }

  public int getTotalCost() {
    int amountOfDays = endDay - startDay + 1;
    int cost = item.getCostPerDay() * amountOfDays;
    return cost;
  }

  public int getEndDay() {
      return endDay;
  }

  public void setEndDay(int endDay) {
      this.endDay = endDay;
  }

  public Item getItem() {
      return item;
  }

  public void setItem(Item item) {
      this.item = item;
  }

  public int getStartDay() {
      return startDay;
  }

  public void setStartDay(int startDay) {
      this.startDay = startDay;
  }
}
