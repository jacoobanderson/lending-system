package model;

import java.util.ArrayList;
import java.util.Random;

public class MemberRegister {
  private ArrayList<Member> members;

  public MemberRegister() {
    this.members = new ArrayList<Member>();
  }

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

  public ArrayList<Member> getMembers() {
      return members;
  }

  public void createMember(String firstName, String lastName, String email, String phoneNumber, int createdAtDay) {
    String id = generateId();
    if (isUnique(email, phoneNumber, id)) {
      Member member = new Member(firstName, lastName, email, phoneNumber, createdAtDay, id);
      members.add(member);
    }
  }

  private String generateId() {
    Random random = new Random();
    String UpperCaseletters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    String id = "";
    int idLengthDividedByTwo = 3;

    for (int i = 0; i < idLengthDividedByTwo; i++) {
      int capitalLetterOrNot = random.nextInt(2);
      int randomLetter = random.nextInt(26);
      int randomNumber = random.nextInt(9);

      if (capitalLetterOrNot == 1) {
        id += UpperCaseletters.charAt(randomLetter);
      } else {
        id += lowerCaseLetters.charAt(randomLetter);
      }

      id += numbers.charAt(randomNumber);
    }
    return id;
  }
}
