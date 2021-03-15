package dev.nincodedo.elevation.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class RaceInstance {

  private List<Driver> drivers;
  private RaceCourse raceCourse;
  private List<Driver> results = new ArrayList<>();
  private Map<Driver, DriverResult> driverTimeMap = new HashMap<>();
  private List<ConditionAffect> raceCourseConditions;
}
