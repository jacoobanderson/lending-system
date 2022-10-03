package model;

import java.util.ArrayList;

public class MemberRegister {
  private ArrayList<Member> members;

  public MemberRegister() {
    this.members = new ArrayList<Member>();
  }

  public boolean isUnique(String email, String phone, String id) {
    boolean isUnique = true;

    for (Member member : members) {
      if (member.getEmail().equals(email)) {
        isUnique = false;
      }
      if (member.getPhoneNumber().equals(phone)) {
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
}
