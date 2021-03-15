package dev.nincodedo.elevation.api;

import lombok.Data;

@Data
public class Driver {

  private String firstName;
  private String lastName;
  private DrivingStyle drivingStyle;
  private Car car = new Car();
  private DriverResult driverResult = new DriverResult();

  public String getName() {
    return firstName + " " + lastName;
  }
}
