package controller;

import model.Member;
import model.MemberRegister;
import view.RegisterView;

public class MemberRegisterController {
  private MemberRegister register;
  private RegisterView view;
  private MemberController memberController;

  public MemberRegisterController(MemberRegister register, RegisterView view, MemberController memberController) {
    this.register = register;
    this.view = view;
    this.memberController = memberController;
  }

  public void createMember() {
    String firstName = view.showFirstNameQuestion();
    String lastName = view.showLastNameQuestion();
    String email = view.showEmailQuestion();
    String phoneNumber = view.showPhoneNumberQuestion();
    register.createMember(firstName, lastName, email, phoneNumber, 0);
  }

  public void showMembersSimple() {
    for (Member member : register.getMembers()) {
      view.printMemberSimple(member.getFirstName(), member.getLastName(), member.getEmail(), member.getCredits(), member.getItems().size());
    }
  }

  public void showMembersVerbose() {
    for (Member member : register.getMembers()) {
      view.printMemberVerbose(member.getFirstName(), member.getLastName(), member.getEmail(), member.getCredits());
      memberController.showItems(member);
    }
  }

  public Member selectMember() {
    String email = view.showMemberEmailQuestion();
    return register.findMemberByEmail(email);
  }

  public void deleteMember(Member member) {
    register.deleteMember(member);
  }
}
