package controller;

import java.util.ArrayList;

import model.Item;
import model.Member;
import view.MemberView;

public class MemberController {
  private MemberView view;

  public MemberController(MemberView view) {
    this.view = view;
  }

  public void showFullMemberInformation(Member member) {
    view.printMemberFullInformation(member.getUniqueId(), member.getFirstName(), member.getLastName(), member.getEmail(), member.getCredits(), member.getCreatedAtDay());
  }

  public void createItem(Member member) {
    String category = view.showItemCategoryQuestion();
    String name = view.showItemNameQuestion();
    String description = view.showItemDescriptionQuestion();
    int cost = view.showItemCostQuestion();

    member.createItem(category, name, description, 0, cost);
  }

  public void showItems(Member member) {
    for (Item item : member.getItems()) {
      view.printMemberItemVerbose(item.getCategory(), item.getName(), item.getDescription(), item.getCostPerDay());
    }
  }

  public void changeFirstName(Member member) {
    String firstName = view.changeFirstNameQuestion();
    member.setFirstName(firstName);
  }

  public void changeLastName(Member member) {
    String lastName = view.changeLastNameQuestion();
    member.setLastName(lastName);
  }

  public void changeEmail(Member member) {
    String email = view.changeEmailQuestion();
    member.setEmail(email);
  }

  public Item selectItem(Member member) {
    int index = 1;
    ArrayList<Item> items = member.getItems();
    for (Item item : items) {
      view.printItemNumber((index++));
      view.printMemberItemVerbose(item.getCategory(), item.getName(), item.getDescription(), item.getCostPerDay());
    }
    int answer = view.selectItemQuestion();
    return items.get(answer - 1);
  }

  public void deleteItem(Item item, Member member) {
    member.deleteItem(item);
  }
}
