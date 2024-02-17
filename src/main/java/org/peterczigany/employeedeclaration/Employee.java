package org.peterczigany.employeedeclaration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "munkavallalo")
public class Employee {

  @Column(name = "munkaviszony_azonosito", nullable = false, unique = true, length = 8)
  @Id
  private String id;

  @Column(name = "vezeteknev", nullable = false)
  private String lastName;

  @Column(name = "keresztnev", nullable = false)
  private String firstName;

  @Column(name = "pozicio", nullable = false)
  private String position;

  @Column(name = "szervezet_kod", nullable = false)
  private String organizationCode;

  @Column(name = "szervezet_nev", nullable = false)
  private String organizationName;

  @Column(name = "vezeto", nullable = false)
  private Boolean isManager;

  protected Employee() {}

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

  public Boolean isManager() {
    return isManager;
  }

  public void setManager(Boolean manager) {
    isManager = manager;
  }
}
