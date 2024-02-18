package org.peterczigany.employeedeclaration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@Table(name = "nyilatkozat")
public class DeclarationDocument {
  @Id @GeneratedValue private Long id;

  @OneToMany
  @JoinColumn(name = "nyilatkozat", nullable = false)
  private List<DeclarationStatement> statements = new ArrayList<>();

  @Column(name = "nyilatkozasi_idoszak_kezdete", nullable = false)
  private LocalDate startOfDeclarationPeriod;

  @Column(name = "nyilatkozasi_idoszak_vege", nullable = false)
  private LocalDate endOfDeclarationPeriod;

  @Column(name = "megorzesi_idoszak_evei", nullable = false, columnDefinition = "integer default 3")
  private Integer retentionPeriodInYears;

  @OneToMany
  @JoinColumn(name = "nyilatkozat", nullable = false)
  private Set<EmployeeDeclaration> employeeDeclarations = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "nyilatkozatokhoz_tartozo_munkavallalok",
      joinColumns = @JoinColumn(name = "nyilatkozat"),
      inverseJoinColumns = @JoinColumn(name = "munkavallalo"))
  Set<Employee> declarers = new HashSet<>();

  protected DeclarationDocument() {}

  public DeclarationDocument(
      Long id,
      List<DeclarationStatement> statements,
      LocalDate startOfDeclarationPeriod,
      LocalDate endOfDeclarationPeriod,
      Integer retentionPeriodInYears,
      Set<EmployeeDeclaration> employeeDeclarations,
      Set<Employee> declarers) {
    this.id = id;
    this.statements = statements;
    this.startOfDeclarationPeriod = startOfDeclarationPeriod;
    this.endOfDeclarationPeriod = endOfDeclarationPeriod;
    this.retentionPeriodInYears = retentionPeriodInYears;
    this.employeeDeclarations = employeeDeclarations;
    this.declarers = declarers;
  }

  public void declare(List<Answer> orderedAnswers, Employee employee) {
    employeeDeclarations.add(
        new EmployeeDeclaration(
            IntStream.range(0, statements.size())
                .boxed()
                .collect(Collectors.toMap(statements::get, orderedAnswers::get)),
            employee));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<DeclarationStatement> getStatements() {
    return statements;
  }

  public void setStatements(List<DeclarationStatement> statements) {
    this.statements = statements;
  }

  public LocalDate getStartOfDeclarationPeriod() {
    return startOfDeclarationPeriod;
  }

  public void setStartOfDeclarationPeriod(LocalDate startOfDeclarationPeriod) {
    this.startOfDeclarationPeriod = startOfDeclarationPeriod;
  }

  public LocalDate getEndOfDeclarationPeriod() {
    return endOfDeclarationPeriod;
  }

  public void setEndOfDeclarationPeriod(LocalDate endOfDeclarationPeriod) {
    this.endOfDeclarationPeriod = endOfDeclarationPeriod;
  }

  public Integer getRetentionPeriod() {
    return retentionPeriodInYears;
  }

  public void setRetentionPeriod(Integer retentionPeriod) {
    this.retentionPeriodInYears = retentionPeriod;
  }

  public Set<EmployeeDeclaration> getEmployeeDeclarations() {
    return employeeDeclarations;
  }

  public void setEmployeeDeclarations(Set<EmployeeDeclaration> employeeDeclarations) {
    this.employeeDeclarations = employeeDeclarations;
  }

  public Set<Employee> getDeclarers() {
    return declarers;
  }

  public void setDeclarers(Set<Employee> declarers) {
    this.declarers = declarers;
  }
}
