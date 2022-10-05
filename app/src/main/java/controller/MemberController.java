package controller;

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
}
