package dev.nincodedo.elevation.api;


import lombok.Getter;

public enum DrivingStyle {
  COMPETENT(1, 1.1), OVERCAUTIOUS(1.05, 1.2), RECKLESS(0.95, 1.25);

  @Getter
  private double durabilityModifier;
  @Getter
  private double width;

  DrivingStyle(double durabilityModifier, double width) {
    this.durabilityModifier = durabilityModifier;
    this.width = width;
  }
}
