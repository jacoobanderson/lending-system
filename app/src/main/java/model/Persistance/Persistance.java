package model.persistance;

import model.MemberRegister;

/**
 * Persistance interface.
 */
public interface Persistance {

  /**
   * Loads the data.
   *
   * @param register The member register.
   */
  public void load(MemberRegister register);
}
