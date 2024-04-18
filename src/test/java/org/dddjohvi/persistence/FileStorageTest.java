package org.dddjohvi.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class FileStorageTest {

  public static final Path STORAGE_FILE_PATH = Path.of("teststorage.json");

  @Test
  void testSavingAndLoading() throws IOException {
    FileStorage fileStorage = new FileStorage(STORAGE_FILE_PATH);

    fileStorage.save(Map.of("foo", "bar"));

    assertThat(fileStorage.load(Map.class))
        .isEqualTo(Map.of("foo", "bar"));
  }

  @AfterEach
  void tearDown() throws IOException {
    Files.deleteIfExists(STORAGE_FILE_PATH);
  }
}