package org.peterczigany.employeedeclaration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "nyilatkozattetel")
public class EmployeeDeclaration {
  @Id @GeneratedValue private Long id;

  @OneToMany private Set<StatementAnswer> statementAnswers = new HashSet<>();

  @Column(name = "munkavallalo", nullable = false)
  @ManyToOne
  private Employee employee;

  protected EmployeeDeclaration() {}

  public EmployeeDeclaration(
      Map<DeclarationStatement, Answer> declarationAnswers, Employee employee) {
    this(
        null,
        declarationAnswers.keySet().stream()
            .map(statement -> new StatementAnswer(statement, declarationAnswers.get(statement)))
            .collect(Collectors.toSet()),
        employee);
  }

  public EmployeeDeclaration(Long id, Set<StatementAnswer> statementAnswers, Employee employee) {
    this.id = id;
    this.statementAnswers = statementAnswers;
    this.employee = employee;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<StatementAnswer> getStatementAnswers() {
    return statementAnswers;
  }

  public void setStatementAnswers(Set<StatementAnswer> statementAnswers) {
    this.statementAnswers = statementAnswers;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
