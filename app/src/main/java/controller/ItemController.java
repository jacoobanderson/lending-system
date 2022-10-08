package controller;

import model.Contract;
import model.Item;
import model.Member;
import model.MemberRegister;
import view.ItemView;

public class ItemController {
  private ItemView view;
  private MemberRegister memberRegister;
  private int day = 1;

  public ItemController(ItemView view, MemberRegister memberRegister) {
    this.view = view;
    this.memberRegister = memberRegister;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public void advanceDay() {
    this.day += 1;
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

  public void showContracts(Item item) {
    for (Contract contract : item.getContracts()) {
      view.viewContract(contract.getStartDay(), contract.getEndDay(), contract.getLenderEmail());
    }
  }

  public void establishContract(Item item, Member ownerOfItem) {
    String lenderOfItemEmail = view.contractMemberQuestion();
    Member lenderOfItem = memberRegister.findMemberByEmail(lenderOfItemEmail);

    int startDay = view.contractStartDayQuestion();
    int endDay = view.contractEndDayQuestion();
    Contract contract = new Contract(item, startDay, endDay, ownerOfItem.getEmail(), lenderOfItemEmail);
    int totalCost = contract.getTotalCost();

    if (item.getAvailableBetweenDays(startDay, endDay) && (ownerOfItem.hasEnoughCredits(totalCost))) {
      transferCredits(lenderOfItem, ownerOfItem, totalCost);
      item.addContract(contract);

      if (getDay() == startDay) {
        lendItem(item);
      }
    }
  }

  public void lendItem(Item item) {
    item.makeItemUnavailable();
  }

  public void returnItem(Item item) {
    item.makeItemAvailable();
  }

  public void transferCredits(Member lenderOfItem, Member ownerOfItem, int credits) {
    ownerOfItem.addCredits(credits);
    lenderOfItem.subtractCredits(credits);
  }
}
