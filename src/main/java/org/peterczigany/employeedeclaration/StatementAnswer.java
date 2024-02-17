package org.peterczigany.employeedeclaration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "valasz")
public class StatementAnswer {
  @Id @GeneratedValue private Long id;

  @Column(name = "allitas", nullable = false)
  @ManyToOne
  private DeclarationStatement statement;

  @Column(name = "ertek", nullable = false)
  private Boolean answer;

  protected StatementAnswer() {}

  public StatementAnswer(DeclarationStatement statement, Boolean answer) {
    this(null, statement, answer);
  }

  public StatementAnswer(Long id, DeclarationStatement statement, Boolean answer) {
    this.id = id;
    this.statement = statement;
    this.answer = answer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DeclarationStatement getStatement() {
    return statement;
  }

  public void setStatement(DeclarationStatement statement) {
    this.statement = statement;
  }

  public Boolean isAnswer() {
    return answer;
  }

  public void setAnswer(Boolean answer) {
    this.answer = answer;
  }
}
