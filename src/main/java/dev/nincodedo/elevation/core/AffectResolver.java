package dev.nincodedo.elevation.core;

import dev.nincodedo.elevation.api.ConditionAffect;
import dev.nincodedo.elevation.api.Driver;
import dev.nincodedo.elevation.api.DrivingStyle;

public class AffectResolver {

  public double resolveAffect(Driver driver, ConditionAffect conditionAffect) {
    return switch (conditionAffect) {
      case WEATHER_RAIN, WEATHER_CLEAR, WEATHER_CLOUDY -> resolveAffect(driver.getDrivingStyle(),
          conditionAffect);
    };
  }

  public double resolveAffect(DrivingStyle drivingStyle, ConditionAffect conditionAffect) {
    return drivingStyle.getDurabilityModifier() * conditionAffect.getModifier();
  }
}
