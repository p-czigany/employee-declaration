package org.peterczigany.employeedeclaration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class EmployeeDeclarationApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeDeclarationApplication.class, args);
  }
}
