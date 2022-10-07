package model;

public class Contract {
  private Member ownerOfItem;
  private Member lenderOfItem;
  private Item item;
  private int startDay;
  private int endDay;
    
  public Contract(Member ownerOfItem, Member lenderOfItem, Item item) {
    this.ownerOfItem = ownerOfItem;
    this.lenderOfItem = lenderOfItem;
    this.item = item;
  }

  public void lendItem() {
    lenderOfItem.addItem(this.item);
    ownerOfItem.deleteItem(this.item);
  }

  public void returnItem() {
    ownerOfItem.addItem(this.item);
    lenderOfItem.deleteItem(this.item);
  }

  public void transferCredits() {
    int credits = item.getCostPerDay();
    ownerOfItem.addCredits(credits);
    lenderOfItem.subtractCredits(credits);
  }
}
