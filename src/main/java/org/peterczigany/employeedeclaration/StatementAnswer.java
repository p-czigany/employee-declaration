package org.peterczigany.employeedeclaration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

  @Enumerated(EnumType.STRING)
  @Column(name = "ertek", nullable = false)
  private Answer answer;

  protected StatementAnswer() {}

  public StatementAnswer(DeclarationStatement statement, Answer answer) {
    this(null, statement, answer);
  }

  public StatementAnswer(Long id, DeclarationStatement statement, Answer answer) {
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

  public Answer getAnswer() {
    return answer;
  }

  public void setAnswer(Answer answer) {
    this.answer = answer;
  }
}
