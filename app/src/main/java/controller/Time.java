package controller;

import model.Contract;
import model.Item;
import model.Member;
import model.MemberRegister;

/**
 * The type time.
 */
public class Time {
  private int day;
  private MemberRegister memberRegister;
  private ItemController itemController;
  private MemberController memberController;
  private MemberRegisterController memberRegisterController;

  /**
   * The constructor.
   *
   * @param day The day.
   * @param memberRegister The member register.
   * @param itemController The item controller.
   * @param memberController The member controller.
   * @param memberRegisterController The member register controller.
   */
  public Time(int day, MemberRegister memberRegister, ItemController itemController, MemberController memberController,
      MemberRegisterController memberRegisterController) {
    this.day = day;
    this.memberRegister = memberRegister;
    this.itemController = itemController;
    this.memberController = memberController;
    this.memberRegisterController = memberRegisterController;
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
   * Advances amount of days.
   *
   * @param day The amount of days to advance.
   */
  public void advanceAmountOfDays(int day) {
    this.day += day;
  }

  /**
   * Advances a day, sets the day of the controllers and calls the handle day change.
   */
  public void advanceDay() {
    advanceAmountOfDays(1);
    itemController.setDay(this.day);
    memberController.setDay(this.day);
    memberRegisterController.setDay(this.day);
    handleDayChange();
  }

  /**
   * Handles the change of day, checks and executes contract functionality.
   */
  public void handleDayChange() {
    for (Member member : memberRegister.getMembers()) {
      for (Item item : member.getItems()) {
        for (Contract contract : item.getContracts()) {
          if (contract.getStartDay() == this.day) {
            itemController.lendItem(item, contract.getLenderEmail(), contract.getStartDay(), contract.getEndDay());
          }
          if (contract.getEndDay() == this.day) {
            itemController.returnItem(item);
          }
        }
      }
    }
  }
}
