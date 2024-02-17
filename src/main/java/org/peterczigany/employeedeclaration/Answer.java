package org.peterczigany.employeedeclaration;

public enum Answer {
  YES("IGEN"),
  NO("NEM");

  private final String value;

  Answer(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
