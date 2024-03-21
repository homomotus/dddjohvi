package org.dddjohvi.cli;

import org.dddjohvi.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  private static Scanner scanner;

  public static void main(String[] args) {
    System.out.println("");
    scanner = new Scanner(System.in);
    Exam exam = init();
    while (true) {

      Applicant applicant = askApplicant();
      List<SubmittedAnswer> submittedAnswers = new ArrayList<>();
      for (Question question : exam.questions()) {
        String answerInput = ask(question.question());
        submittedAnswers.add(new SubmittedAnswer(question, new Answer(answerInput)));
      }
      exam.submit(applicant, submittedAnswers);
      System.out.println("Current top is:");
      System.out.println(exam.top());
    }
  }

  private static Applicant askApplicant() {
    while (true) {
      try {
        String fullName = ask("Type your full name:");
        String emailInput = ask("Type your email:");
        return new Applicant(fullName, new Email(emailInput));
      } catch (Exception e) {
        System.out.println(e.getClass().getSimpleName());
      }
    }
  }

  private static String ask(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  private static Exam init() {
    Question question1 = new Question("How much 2x2?");
    ExamQuestion examQuestion1 = new ExamQuestion(question1, new Answer("4"));
    Question question2 = new Question("Capital of Great Britain?");
    ExamQuestion examQuestion2 = new ExamQuestion(question2, new Answer("London"));

    return new Exam(List.of(examQuestion1, examQuestion2));
  }
}