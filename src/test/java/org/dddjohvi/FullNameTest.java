package org.dddjohvi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FullNameTest {
  @ParameterizedTest
  @ValueSource(strings = {"", " ", "  \t"})
  @NullSource
  void shouldNotBeBlank(String value) {
    assertThatThrownBy(() -> new FullName(value))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Empty");
  }
}