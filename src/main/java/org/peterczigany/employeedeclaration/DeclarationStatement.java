package org.peterczigany.employeedeclaration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "allitas")
public class DeclarationStatement {
  @Id @GeneratedValue private Long id;

  @Column(name = "allistas_szovege_html", nullable = false)
  private String statementHtml;

  protected DeclarationStatement() {}

  public DeclarationStatement(Long id, String statementHtml) {
    this.id = id;
    this.statementHtml = statementHtml;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStatementHtml() {
    return statementHtml;
  }

  public void setStatementHtml(String statementHtml) {
    this.statementHtml = statementHtml;
  }
}
