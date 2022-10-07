package model;

public class Contract {
  private Item item;
  private int startDay;
  private int endDay;
    
  public Contract(Item item, int startDay, int endDay) {
    this.item = item;
    this.startDay = startDay;
    this.endDay = endDay;
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
  // public void lendItem() {
  //   lenderOfItem.addItem(this.item);
  //   ownerOfItem.deleteItem(this.item);
  // }

  // public void returnItem() {
  //   ownerOfItem.addItem(this.item);
  //   lenderOfItem.deleteItem(this.item);
  // }

  // public void transferCredits() {
  //   int credits = item.getCostPerDay();
  //   ownerOfItem.addCredits(credits);
  //   lenderOfItem.subtractCredits(credits);
  // }
}
