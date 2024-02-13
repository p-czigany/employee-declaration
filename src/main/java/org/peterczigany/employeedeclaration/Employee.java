package org.peterczigany.employeedeclaration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
  @Id private String id;

  private String lastName;
  private String firstName;
  private String position;
  private String organizationCode;
  private String organizationName;
  private Boolean isManager;

  public Employee() {}

  public Employee(
      String id,
      String lastName,
      String firstName,
      String position,
      String organizationCode,
      String organizationName,
      Boolean isManager) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.position = position;
    this.organizationCode = organizationCode;
    this.organizationName = organizationName;
    this.isManager = isManager;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getOrganizationCode() {
    return organizationCode;
  }

  public void setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public Boolean getManager() {
    return isManager;
  }

  public void setManager(Boolean manager) {
    isManager = manager;
  }
}
