package dev.nincodedo.elevation.api;

import lombok.Getter;

public enum ConditionAffect {
  WEATHER_RAIN(1.15), WEATHER_CLEAR(1), WEATHER_CLOUDY(1.05);

  @Getter
  private final double modifier;

  ConditionAffect(double modifier) {
    this.modifier = modifier;
  }
}
