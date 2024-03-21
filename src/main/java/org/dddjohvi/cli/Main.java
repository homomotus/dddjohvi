package org.dddjohvi.cli;

import org.dddjohvi.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("");
    Scanner scanner = new Scanner(System.in);
    Exam exam = init();
    while (true) {
      System.out.println("Type your full name:");
      String fullName = scanner.nextLine();
      System.out.println("Type your email:");
      String emailInput = scanner.nextLine();
      Applicant applicant = new Applicant(fullName, new Email(emailInput));
      List<SubmittedAnswer> submittedAnswers = new ArrayList<>();
      for (Question question : exam.questions()) {
        System.out.println(question.question());
        System.out.println("Type your answer:");
        String answerInput = scanner.nextLine();
        submittedAnswers.add(new SubmittedAnswer(question, new Answer(answerInput)));
      }
      exam.submit(applicant, submittedAnswers);
      System.out.println("Current top is:");
      System.out.println(exam.top());
    }
  }
  private static Exam init() {
    Question question1 = new Question("How much 2x2?");
    ExamQuestion examQuestion1 = new ExamQuestion(question1, new Answer("4"));
    Question question2 = new Question("Capital of Great Britain?");
    ExamQuestion examQuestion2 = new ExamQuestion(question2, new Answer("London"));

    return new Exam(List.of(examQuestion1, examQuestion2));
  }
}