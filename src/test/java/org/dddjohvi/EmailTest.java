package org.dddjohvi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {
  @ParameterizedTest
  @ValueSource(strings = {"", " ", "  \t"})
  @NullSource
  void emailShouldNotBeBlank(String email) {
    assertThatThrownBy(() -> new Email(email))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Empty");
  }

  @Test
  void emailShouldBeValid() {
    assertThatThrownBy(() -> new Email("noatsymbol.here"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("No @");
  }
}