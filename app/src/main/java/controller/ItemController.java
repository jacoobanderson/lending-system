package controller;

import model.Contract;
import model.Item;
import model.Member;
import model.MemberRegister;
import view.ItemView;

public class ItemController {
  private ItemView view;
  private MemberRegister memberRegister;

  public ItemController(ItemView view, MemberRegister memberRegister) {
    this.view = view;
    this.memberRegister = memberRegister;
  }
   
  public void changeCategory(Item item) {
    String category = view.changeItemCategoryQuestion();
    item.setCategory(category);
  }

  public void changeName(Item item) {
    String name = view.changeItemNameQuestion();
    item.setName(name);
  }

  public void changeDescription(Item item) {
    String description = view.changeItemDescriptionQuestion();
    item.setDescription(description);
  }

  public void changeCost(Item item) {
    int cost = view.changeItemCostQuestion();
    item.setCostPerDay(cost);
  }

  public void establishContract(Item item, Member ownerOfItem) {
    String lenderOfItemEmail = view.contractMemberQuestion();
    Member lenderOfItem = memberRegister.findMemberByEmail(lenderOfItemEmail);

    int startDay = view.contractStartDayQuestion();
    int endDay = view.contractEndDayQuestion();

    Contract contract = new Contract(item, startDay, endDay);
  }

  public void lendItem(Member lenderOfItem, Member ownerOfItem, Item item) {
    lenderOfItem.addItem(item);
    ownerOfItem.deleteItem(item);
  }

  public void returnItem(Member lenderOfItem, Member ownerOfItem, Item item) {
    ownerOfItem.addItem(item);
    lenderOfItem.deleteItem(item);
  }

  public void transferCredits(Member lenderOfItem, Member ownerOfItem, Item item) {
    int credits = item.getCostPerDay();
    ownerOfItem.addCredits(credits);
    lenderOfItem.subtractCredits(credits);
  }


}
