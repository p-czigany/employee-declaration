package org.peterczigany.employeedeclaration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class StatementAnswer {
  @Id @GeneratedValue private Long id;

  @ManyToOne private DeclarationStatement statement;
  private Boolean answer;

  public StatementAnswer() {}

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
