package model;

public class Item {
  private String category;
  private String name;
  private String description;
  private int createdAtDay;
  private int costPerDay;

  public Item(String category, String name, String description, int createdAtDay, int costPerDay) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.createdAtDay = createdAtDay;
    this.costPerDay = costPerDay;
  }

  public String getCategory() {
      return category;
  }

  public void setCategory(String category) {
      this.category = category;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getDescription() {
      return description;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public int getCreatedAtDay() {
      return createdAtDay;
  }

  public void setCreatedAtDay(int createdAtDay) {
      this.createdAtDay = createdAtDay;
  }

  public int getCostPerDay() {
      return costPerDay;
  }

  public void setCostPerDay(int costPerDay) {
      this.costPerDay = costPerDay;
  }
}
