package model;

import java.util.ArrayList;
import java.util.Random;
import model.persistance.Data;

/**
 * The member register.
 */
public class MemberRegister {
  private ArrayList<Member> members;

  /**
   * The constructor.
   */
  public MemberRegister() {
    this.members = new ArrayList<Member>();
    new Data().load(this);
  }

  /**
   * Checks if unique. 
   *
   * @param email The email.
   * @param phoneNumber The phone number.
   * @param id The id.
   * @return If it is unique.
   */
  public boolean isUnique(String email, String phoneNumber, String id) {
    boolean isUnique = true;

    for (Member member : members) {
      if (member.getEmail().equals(email)) {
        isUnique = false;
      }
      if (member.getPhoneNumber().equals(phoneNumber)) {
        isUnique = false;
      }
      if (member.getUniqueId().equals(id)) {
        isUnique = false;
      }
    }
    return isUnique;
  }

  /**
   * Gets the members. 
   *
   * @return The members.
   */
  public ArrayList<Member> getMembers() {
    return members;
  }

  /**
   * Creates a member.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param email The email.
   * @param phoneNumber The phone number.
   * @param createdAtDay The day the member was created.
   */
  public void createMember(String firstName, String lastName, String email, String phoneNumber, int createdAtDay) {
    String id = generateId();
    if (isUnique(email, phoneNumber, id)) {
      Member member = new Member(firstName, lastName, email, phoneNumber, createdAtDay, id);
      this.members.add(member);
    }
  }

  /**
   * Adds a member to the list.
   *
   * @param member The member.
   */
  public void addMember(Member member) {
    this.members.add(member);
  }

  /**
   * Deletes a member.
   *
   * @param member The member.
   */
  public void deleteMember(Member member) {
    this.members.remove(member);
  }

  /**
   * Finds a member by id.
   *
   * @param uniqueId The unique id.
   * @return A member.
   */
  public Member findMemberById(String uniqueId) {
    for (Member member : members) {
      if (uniqueId.equals(member.getUniqueId())) {
        return member;
      }
    }
    return null;
  }

  /**
   * Finds a member by email.
   *
   * @param email The email.
   * @return The member.
   */
  public Member findMemberByEmail(String email) {
    for (Member member : members) {
      if (email.equals(member.getEmail())) {
        return member;
      }
    }
    return null;
  }

  /**
   * Generates an id.
   *
   * @return The id.
   */
  private String generateId() {
    Random random = new Random();
    String upperCaseletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    String id = "";
    int idLengthDividedByTwo = 3;

    for (int i = 0; i < idLengthDividedByTwo; i++) {
      int capitalLetterOrNot = random.nextInt(2);
      int randomLetter = random.nextInt(26);
      int randomNumber = random.nextInt(9);

      if (capitalLetterOrNot == 1) {
        id += upperCaseletters.charAt(randomLetter);
      } else {
        id += lowerCaseLetters.charAt(randomLetter);
      }

      id += numbers.charAt(randomNumber);
    }
    return id;
  }
}
