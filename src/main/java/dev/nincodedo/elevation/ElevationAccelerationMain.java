package dev.nincodedo.elevation;

import dev.nincodedo.elevation.api.Driver;
import dev.nincodedo.elevation.api.DriverResult;
import dev.nincodedo.elevation.api.RaceCourse;
import dev.nincodedo.elevation.api.RaceInstance;
import dev.nincodedo.elevation.core.DriverGenerator;
import dev.nincodedo.elevation.core.RaceCourseGenerator;
import dev.nincodedo.elevation.core.RaceSimulator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ElevationAccelerationMain {

  public static void main(String[] args) {
    Random random = new Random(1);
    DriverGenerator driverGenerator = new DriverGenerator();
    RaceCourseGenerator raceCourseGenerator = new RaceCourseGenerator();
    List<Driver> driverList = new ArrayList<>();
    int racers = 8;
    for (int i = 0; i < racers; i++) {
      driverList.add(driverGenerator.generateDriver(random));
    }

    RaceCourse raceCourse = raceCourseGenerator.generateRaceCourse(random);
    RaceInstance raceInstance = new RaceInstance();
    raceInstance.setDrivers(driverList);
    raceInstance.setRaceCourse(raceCourse);
    RaceSimulator raceSimulator = new RaceSimulator(raceInstance);
    raceSimulator.simulateRace(random);

    List<Driver> results = new ArrayList<>(List.copyOf(raceInstance.getDriverTimeMap().keySet()));
    results
        .sort(Comparator.comparing(o -> raceSimulator.getRaceInstance().getDriverTimeMap().get(o).raceTime()));
    System.out.println(raceCourse);
    for (int i = 0; i < results.size(); i++) {
      Driver driver = results.get(i);
      DriverResult driverResult = raceSimulator.getRaceInstance().getDriverTimeMap().get(driver);
      System.out.println(
          "Place: #" + (i + 1) + " " + driver.getName() + ", " + driverResult.readableRaceTime() + ": " + driver
              .getDrivingStyle());
      System.out.println(driverResult.lapTimes());
    }
  }
}
