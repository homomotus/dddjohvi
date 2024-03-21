package org.dddjohvi;

import java.util.Objects;

public final class Email {
  private final String email;

  public Email(String email) {
    if (email == null || email.isBlank()) {
      throw new EmailIsMissingException();
    }
    if (!email.contains("@")) {
      throw new InvalidEmailException();
    }
    this.email = email;
  }

  public String email() {
    return email;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Email) obj;
    return Objects.equals(this.email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public String toString() {
    return "Email[" +
        "email=" + email + ']';
  }

}
