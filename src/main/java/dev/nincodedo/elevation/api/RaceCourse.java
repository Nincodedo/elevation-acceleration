package dev.nincodedo.elevation.api;

import lombok.Data;

@Data
public class RaceCourse {
  private String name;
  private int laps;
  private double averageLap;
  private int difficulty;
}
