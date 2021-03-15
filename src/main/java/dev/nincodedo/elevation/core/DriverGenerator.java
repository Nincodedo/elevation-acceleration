package dev.nincodedo.elevation.core;

import dev.nincodedo.elevation.api.Driver;
import dev.nincodedo.elevation.api.DrivingStyle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DriverGenerator {

  private List<String> firstNames;
  private List<String> lastNames;

  public DriverGenerator() {
    firstNames = readWordList("driver-first-names.txt");
    lastNames = readWordList("driver-last-names.txt");
  }

  public Driver generateDriver(Random random) {
    Driver driver = new Driver();
    driver.setFirstName(firstNames.remove(random.nextInt(firstNames.size())));
    driver.setLastName(lastNames.get(random.nextInt(lastNames.size())));
    driver.setDrivingStyle(DrivingStyle.values()[random.nextInt(DrivingStyle.values().length)]);
    return driver;
  }

  private List<String> readWordList(String fileName) {
    List<String> list = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(
        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName))))) {
      String line;
      while ((line = br.readLine()) != null) {
        list.add(line);
      }
    } catch (IOException e) {
      log.error("Failed to read common word file", e);
      return new ArrayList<>();
    }
    return list;
  }

}
