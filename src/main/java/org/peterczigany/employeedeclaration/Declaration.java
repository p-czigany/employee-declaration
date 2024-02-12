package org.peterczigany.employeedeclaration;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Declaration {
  private String id;
  private List<EmployeeDeclaration> employeeDeclarations = new ArrayList<>();

  public Declaration() {}
  public Declaration(String id, List<EmployeeDeclaration> employeeDeclarations) {
    this.id = id;
    this.employeeDeclarations = employeeDeclarations;
  }

  public void declare(EmployeeDeclaration employeeDeclaration) {
    employeeDeclarations.add(employeeDeclaration);
  }
}
