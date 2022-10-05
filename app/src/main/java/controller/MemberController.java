package controller;

import model.Member;
import view.MemberView;

public class MemberController {
  private MemberView view;

  public MemberController(MemberView view) {
    this.view = view;
  }

  public void showFullMemberInformation(Member member) {
    view.printMemberFullInformation(member.getUniqueId(), member.getFirstName(), member.getLastName(), member.getEmail(), member.getCredits(), member.getCreatedAtDay());
  }
}
