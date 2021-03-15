package dev.nincodedo.elevation.core;

import dev.nincodedo.elevation.api.ConditionAffect;
import dev.nincodedo.elevation.api.Driver;
import dev.nincodedo.elevation.api.DriverResult;
import dev.nincodedo.elevation.api.RaceCourse;
import dev.nincodedo.elevation.api.RaceInstance;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Data;

@Data
public class RaceSimulator {

  private final RaceInstance raceInstance;
  private final ConditionAffectGenerator conditionAffectGenerator;

  public RaceSimulator(RaceInstance raceInstance) {
    this.raceInstance = raceInstance;
    this.conditionAffectGenerator = new ConditionAffectGenerator();
  }

  public void simulateRace(Random random) {
    List<Driver> tempDrivers = new ArrayList<>(raceInstance.getDrivers());
    RaceCourse raceCourse = raceInstance.getRaceCourse();
    List<ConditionAffect> raceAffects = conditionAffectGenerator
        .generateConditions(raceCourse.getDifficulty());
    while (!tempDrivers.isEmpty()) {
      Driver driver = tempDrivers.remove(random.nextInt(tempDrivers.size()));
      raceInstance.getDriverTimeMap()
          .put(driver, getRaceTime(raceCourse, raceAffects, driver, random));
    }
  }

  private DriverResult getRaceTime(RaceCourse raceCourse, List<ConditionAffect> raceAffects,
      Driver driver, Random random) {
    DriverResult driverResult = new DriverResult();
    double lapTime = raceCourse.getAverageLap();
    AffectResolver affectResolver = new AffectResolver();
    for (ConditionAffect affect : raceAffects) {
      lapTime *= affectResolver.resolveAffect(driver, affect);
    }
    for (int i = 0; i < raceCourse.getLaps(); i++) {
      driverResult.getLapTimes()
          .add((random.nextDouble() * (driver.getDrivingStyle().getWidth() / 2.0) + driver
              .getDrivingStyle().getWidth() / 2.0) * lapTime);
    }

    return driverResult;
  }
}
