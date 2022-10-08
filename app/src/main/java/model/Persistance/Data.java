package model.persistance;

import model.Contract;
import model.Item;
import model.Member;
import model.MemberRegister;

/**
 * The Data.
 */
public class Data implements Persistance {
  
  /**
   * Loads the register with data.
   */
  public void load(MemberRegister memberRegister) {
    Member personOne = new Member("Svante", "Svantesson", "svante@gmail.com", "057458329", 1, "1d4F61");

    personOne.createItem("Tool", "Hammer", "You can hammer stuff", 1, 5);
    personOne.createItem("Vehicle", "Car", "You can dive", 1, 10);

    Item lendedItem = new Item("Tool", "Screwdriver", "You can screw", 1, 5, true);
    Contract contract = new Contract(lendedItem, 5, 7, "nisse@gmail.com", "svante@gmail.com");
    lendedItem.addContract(contract);

    Member personThree = new Member("Nisse", "Nissesson", "nisse@gmail.com", "0575338329", 1, "1d8F12");
    personThree.addItem(lendedItem);
    personThree.addCredits(100);

    Member personTwo = new Member("Karl", "Karlsson", "karl@gmail.com", "0574123329", 1, "2d4F51");
    memberRegister.addMember(personOne);
    memberRegister.addMember(personTwo);
    memberRegister.addMember(personThree);
  }
}
