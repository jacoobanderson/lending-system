package controller;

import java.util.ArrayList;
import model.Item;
import model.Member;
import view.MemberView;

/**
 * The member controller.
 */
public class MemberController {
  private MemberView view;
  private int day = 1;

  /**
   * The constructor.
   *
   * @param view The member view.
   */
  public MemberController(MemberView view) {
    this.view = view;
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
   * Shows the full member information.
   *
   * @param member The member.
   */
  public void showFullMemberInformation(Member member) {
    view.printMemberFullInformation(member.getUniqueId(), member.getFirstName(), member.getLastName(),
        member.getEmail(), member.getCredits(), member.getCreatedAtDay());
  }

  /**
   * Creates an item.
   *
   * @param member The member that should have the item.
   */
  public void createItem(Member member) {
    String category = view.showItemCategoryQuestion();
    String name = view.showItemNameQuestion();
    String description = view.showItemDescriptionQuestion();
    int cost = view.showItemCostQuestion();

    member.createItem(category, name, description, getDay(), cost);
  }

  /**
   * Shows all the items.
   *
   * @param member The member who owns the items.
   */
  public void showItems(Member member) {
    for (Item item : member.getItems()) {
      view.printMemberItemVerbose(item.getCategory(), item.getName(), item.getDescription(), item.getCostPerDay(),
          item.getCurrentlyLentTo(), item.getCurrentContractStartDay(), item.getCurrentContractEndDay());
    }
  }

  /**
   * Shows the view and changes the first name.
   *
   * @param member The member.
   */
  public void changeFirstName(Member member) {
    String firstName = view.changeFirstNameQuestion();
    member.setFirstName(firstName);
  }

  /**
   * Shows the view and changes the last name.
   *
   * @param member The member.
   */
  public void changeLastName(Member member) {
    String lastName = view.changeLastNameQuestion();
    member.setLastName(lastName);
  }

  /**
   * Show email view and change email.
   */
  public void changeEmail(Member member) {
    String email = view.changeEmailQuestion();
    member.setEmail(email);
  }

  /**
   * Shows the select item view and selects the item.
   *
   * @param member The member.
   * @return The item.
   */
  public Item selectItem(Member member) {
    int index = 1;
    ArrayList<Item> items = member.getItems();
    for (Item item : items) {
      if (item.getAvailableForLoan()) {
        view.printItemNumber((index++));
        view.printMemberItemVerbose(item.getCategory(), item.getName(), item.getDescription(), item.getCostPerDay(),
            item.getCurrentlyLentTo(), item.getCurrentContractStartDay(), item.getCurrentContractEndDay());
      }
    }
    int answer = view.selectItemQuestion();
    return items.get(answer - 1);
  }

  /**
   * Delets an item.
   *
   * @param item   The item.
   * @param member The member.
   */
  public void deleteItem(Item item, Member member) {
    member.deleteItem(item);
  }
}
