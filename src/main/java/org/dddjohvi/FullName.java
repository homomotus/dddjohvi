package org.dddjohvi;

public class FullName {
  private final String fullName;

  public FullName(String fullName) {
    if (fullName == null || fullName.isBlank()) {
      throw new IllegalArgumentException("Empty");
    }
    this.fullName = fullName;
  }

  public String value() {
    return fullName;
  }
}
