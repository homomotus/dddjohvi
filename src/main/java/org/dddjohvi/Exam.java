package org.dddjohvi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exam {

  final List<ExamQuestion> questions;
  private final List<ExamResult> results = new ArrayList<>();

  public Exam(List<ExamQuestion> questions) {
    this.questions = questions;
  }

  public List<Question> questions() {
    return questions.stream().map(ExamQuestion::question).toList();
  }

  public ExamResult submit(Applicant applicant, List<SubmittedAnswer> answers) {
    int totalScore = 0;
    for (SubmittedAnswer answer : answers) {
      ExamQuestion examQuestion = questions.stream().filter(question -> question.question().equals(answer.question())).findFirst().orElseThrow();
      totalScore += examQuestion.match(answer) ? 1 : 0;
    }
    ExamResult examResult = new ExamResult(applicant, totalScore);
    results.add(examResult);
    return examResult;
  }

  public List<Applicant> top() {
    return results.stream()
        .sorted(Comparator.comparing(ExamResult::value).reversed())
        .map(ExamResult::applicant).toList();
  }
}
