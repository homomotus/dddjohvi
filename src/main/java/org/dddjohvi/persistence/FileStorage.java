package org.dddjohvi.persistence;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileStorage {

  private Path filePath;
  private ObjectMapper objectMapper;

  public FileStorage(Path filePath) {
    this.filePath = filePath;
    objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
  }

  public void save(Object object) {
    try {
      FileWriter writer = new FileWriter(filePath.toFile(), false);
      objectMapper.writeValue(writer, object);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public <T> T load(Class<T> clazz) {
    try {
      return new ObjectMapper().readValue(filePath.toFile(), clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
