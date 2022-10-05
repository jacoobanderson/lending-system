package controller;

import model.MemberRegister;
import view.RegisterView;

public class MemberRegisterController {
  private MemberRegister register;
  private RegisterView view;

  public MemberRegisterController(MemberRegister register, RegisterView view) {
    this.register = register;
    this.view = view;
  }
}
