package controller;

import model.Contract;
import model.Item;
import model.Member;
import model.MemberRegister;

public class Time {
  private int day;
  private MemberRegister memberRegister;
  private ItemController itemController;
  private MemberController memberController;
  private MemberRegisterController memberRegisterController;

  public Time(int day, MemberRegister memberRegister, ItemController itemController, MemberController memberController,
      MemberRegisterController memberRegisterController) {
    this.day = day;
    this.memberRegister = memberRegister;
    this.itemController = itemController;
    this.memberController = memberController;
    this.memberRegisterController = memberRegisterController;
  }

  public int getDay() {
    return day;
  }

  public void advanceDay(int day) {
    this.day += day;
  }

  public void advanceDay() {
    advanceDay(1);
    itemController.setDay(this.day);
    memberController.setDay(this.day);
    memberRegisterController.setDay(this.day);
    handleDayChange();
  }

  public void handleDayChange() {
      for (Member member : memberRegister.getMembers()) {
        for (Item item : member.getItems()) {
          for (Contract contract : item.getContracts()) {
            if (contract.getStartDay() == this.day) {
              itemController.lendItem(item, contract.getLenderEmail());
            }
            if (contract.getEndDay() == this.day) {
              itemController.returnItem(item);
            }
          }
        }
      }
  }
}
