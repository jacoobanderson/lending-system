package model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

  /**
   * The constructor.
   *
   * @param day                      The day.
   * @param memberRegister           The member register.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Time needs to use each controller.")
  public Time(int day, MemberRegister memberRegister) {
    this.day = day;
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
   * Advances amount of days.
   *
   * @param day The amount of days to advance.
   */
  public void advanceAmountOfDays(int day) {
    this.day += day;
  }

  /**
   * Advances a day, sets the day of the controllers and calls the handle day
   * change.
   */
  public void advanceDay() {
    advanceAmountOfDays(1);
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
            item.makeItemUnavailable();
            item.setCurrentlyLentTo(contract.getLenderEmail());
            item.setCurrentContractStartDay(contract.getStartDay());
            item.setCurrentContractEndDay(contract.getEndDay());
          }
          if (contract.getEndDay() == this.day) {
            item.makeItemAvailable();
            item.setCurrentlyLentTo(null);
            item.setCurrentContractStartDay(0);
            item.setCurrentContractEndDay(0);
          }
        }
      }
    }
  }
}
