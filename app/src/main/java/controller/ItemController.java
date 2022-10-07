package controller;

import model.Item;
import view.ItemView;

public class ItemController {
  private ItemView view;

  public ItemController(ItemView view) {
    this.view = view;
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
}
