package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import model.Contract;
import model.Item;
import model.Member;
import model.MemberRegister;
import view.ItemView;

/**
 * The item controller.
 */
public class ItemController {
  private ItemView view;
  private MemberRegister memberRegister;
  private int day = 1;

  /**
   * The constructor.
   *
   * @param view           The item view.
   * @param memberRegister The member register.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Controller needs access to model")
  public ItemController(ItemView view, MemberRegister memberRegister) {
    this.view = view;
    this.memberRegister = memberRegister;
  }

  /**
   * Gets the day.
   *
   * @return The day.
   */
  public int getDay() {
    return day;
  }

  /**
   * Sets the day.
   *
   * @param day The day.
   */
  public void setDay(int day) {
    this.day = day;
  }

  /**
   * Advances a day.
   */
  public void advanceDay() {
    this.day += 1;
  }

  /**
   * Changes the category of an item.
   *
   * @param item The item.
   */
  public void changeCategory(Item item) {
    String category = view.changeItemCategoryQuestion();
    item.setCategory(category);
  }

  /**
   * Changes the name of an item.
   *
   * @param item The item.
   */
  public void changeName(Item item) {
    String name = view.changeItemNameQuestion();
    item.setName(name);
  }

  /**
   * Changes the description of an item.
   *
   * @param item The item.
   */
  public void changeDescription(Item item) {
    String description = view.changeItemDescriptionQuestion();
    item.setDescription(description);
  }

  /**
   * Changes the cost of an item.
   *
   * @param item The item.
   */
  public void changeCost(Item item) {
    int cost = view.changeItemCostQuestion();
    item.setCostPerDay(cost);
  }

  /**
   * Shows the contracts of an item.
   *
   * @param item The items.
   */
  public void showContracts(Item item) {
    for (Contract contract : item.getContracts()) {
      view.viewContract(contract.getStartDay(), contract.getEndDay(), contract.getLenderEmail());
    }
  }

  /**
   * Establishes a contract.
   *
   * @param item        The item that is to be in the contract.
   * @param ownerOfItem The owner of the item.
   */
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
        item.makeItemUnavailable();
        item.setCurrentlyLentTo(lenderOfItemEmail);
        item.setCurrentContractStartDay(startDay);
        item.setCurrentContractEndDay(endDay);
      }
    }
  }

  /**
   * Transfers the credits.
   *
   * @param lenderOfItem The lender of the item.
   * @param ownerOfItem  The owner of the item.
   * @param credits      The amount of credits.
   */
  public void transferCredits(Member lenderOfItem, Member ownerOfItem, int credits) {
    lenderOfItem.transferCredits(ownerOfItem, credits);
  }
}
