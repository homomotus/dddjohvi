package org.dddjohvi.cli;

import org.dddjohvi.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CliApplication {
  public static void main(String[] args) {
    System.out.println("Starting program. Type 'q' to exit");

    Question question1 = new Question("How much 2x2?");
    ExamQuestion examQuestion1 = new ExamQuestion(question1, new Answer("4"));
    Question question2 = new Question("Capital of Great Britain?");
    ExamQuestion examQuestion2 = new ExamQuestion(question2, new Answer("London"));
    Exam exam = new Exam(List.of(examQuestion1, examQuestion2));

    Scanner scanner = new Scanner(System.in);
    boolean cont = true;
    while (cont) {
      System.out.println("Full name:");
      String fullName = scanner.next();

      System.out.println("Email:");
      String email = scanner.next();

      Applicant applicant = new Applicant(fullName, new Email(email));
      List<SubmittedAnswer> submittedAnswers = new ArrayList<>();
      exam.questions().forEach(question -> {
        System.out.println(question.question());
        String answer = scanner.next();
        submittedAnswers.add(new SubmittedAnswer(question, new Answer(answer)));
      });
      exam.submit(applicant, submittedAnswers);
      cont = false;
    }
    System.out.println(exam.top());
    // exam
    // while not exit symbol
    // input full name
    // input email
    // question 1 answer
    // question 2 answer
    // if 'q' then
    // print top applicants
  }
}
