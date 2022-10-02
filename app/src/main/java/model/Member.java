package model;

/**
 * The type member.
 */
public class Member {
  // private String uniqueId;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  // private String createdAt;

  /**
   * Instantiates a new member.
   *
   * @param firstName   The first name.
   * @param lastName    The last name.
   * @param email       The email.
   * @param phoneNumber The phone number.
   */
  public Member(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  /**
   * Gets the first name.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name.
   *
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName The last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the email.
   *
   * @return The email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email The email.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the phone number.
   *
   * @return The phone number.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Sets the phone number.
   *
   * @param phoneNumber The phone number.
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  // public String generateId() {

  // }

}
