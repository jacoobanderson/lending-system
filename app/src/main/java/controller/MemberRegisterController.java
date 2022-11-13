package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import model.Member;
import model.MemberRegister;
import model.Time;
import view.RegisterView;

/**
 * The member register controller.
 */
public class MemberRegisterController {
  private MemberRegister register;
  private RegisterView view;
  private MemberController memberController;
  private Time time;

  /**
   * The constructor.
   *
   * @param register         The member register.
   * @param view             The Register view.
   * @param memberController The member controller.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Main controller needs access")
  public MemberRegisterController(MemberRegister register, RegisterView view, MemberController memberController,
      Time time) {
    this.register = register;
    this.view = view;
    this.memberController = memberController;
    this.time = time;
  }

  /**
   * Creates a member.
   */
  public void createMember() {
    String firstName = view.showFirstNameQuestion();
    String lastName = view.showLastNameQuestion();
    String email = view.showEmailQuestion();
    String phoneNumber = view.showPhoneNumberQuestion();
    register.createMember(firstName, lastName, email, phoneNumber, time.getDay());
  }

  /**
   * Shows the members in the simple version.
   */
  public void showMembersSimple() {
    for (Member member : register.getMembers()) {
      view.printMemberSimple(member.getFirstName(), member.getLastName(), member.getEmail(), member.getCredits(),
          member.getItems().size());
    }
  }

  /**
   * Shows the members in verbose version.
   */
  public void showMembersVerbose() {
    for (Member member : register.getMembers()) {
      view.printMemberVerbose(member.getFirstName(), member.getLastName(), member.getEmail(), member.getCredits(),
          member.getUniqueId());
      memberController.showItems(member);
    }
  }

  /**
   * Selects a specific member.
   *
   * @return The member.
   */
  public Member selectMember() {
    String email = view.showMemberEmailQuestion();
    return register.findMemberByEmail(email);
  }

  /**
   * Deletes a member.
   *
   * @param member The member.
   */
  public void deleteMember(Member member) {
    register.deleteMember(member);
  }
}
