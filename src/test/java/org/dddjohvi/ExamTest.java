package org.dddjohvi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamTest {
  @Test
  void examWillReturnScore() {
    Question question1 = new Question("How much 2x2?");
    ExamQuestion examQuestion1 = new ExamQuestion(question1, new Answer("4"));
    Question question2 = new Question("Capital of Great Britain?");
    ExamQuestion examQuestion2 = new ExamQuestion(question2, new Answer("London"));

    Exam exam = new Exam(List.of(examQuestion1, examQuestion2));
    Applicant john = new Applicant(new FullName("John"), new Email("john@mail.com"));
    Applicant bob = new Applicant(new FullName("Bob"), new Email("bob@email.com"));
    ExamResult bobResult = exam.submit(bob, List.of(
        new SubmittedAnswer(question1, new Answer("5")),
        new SubmittedAnswer(question2, new Answer("London"))
    ));
    ExamResult johnResult = exam.submit(john, List.of(
        new SubmittedAnswer(question1, new Answer("4")),
        new SubmittedAnswer(question2, new Answer("London"))
    ));
    assertThat(bobResult).isEqualTo(new ExamResult(bob, 1));
    assertThat(johnResult).isEqualTo(new ExamResult(john, 2));

    List<Applicant> top = exam.top();

    assertThat(top).isEqualTo(List.of(john, bob));
  }
}
