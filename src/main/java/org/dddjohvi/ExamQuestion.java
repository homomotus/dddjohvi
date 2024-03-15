package org.dddjohvi;

public record ExamQuestion(Question question,Answer correctAnswer) {
  public boolean match(SubmittedAnswer submittedAnswer) {
    return submittedAnswer.answer().equals(correctAnswer);
  }
}
