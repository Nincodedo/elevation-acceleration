package dev.nincodedo.elevation.core;

import dev.nincodedo.elevation.api.RaceCourse;
import java.util.Random;

public class RaceCourseGenerator {

  public RaceCourse generateRaceCourse(Random random) {
    RaceCourse raceCourse = new RaceCourse();
    raceCourse.setName("Mario Raceway");
    raceCourse.setLaps(random.nextInt(5) + 2);
    raceCourse.setAverageLap(random.nextDouble() * 200 + 30);
    raceCourse.setDifficulty(random.nextInt(5) + 1);
    return raceCourse;
  }

}
