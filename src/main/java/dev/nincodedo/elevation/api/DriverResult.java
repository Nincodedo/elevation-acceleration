package dev.nincodedo.elevation.api;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class DriverResult {

  private List<Double> lapTimes = new ArrayList<>();

  public List<String> lapTimes() {
    return lapTimes.stream()
        .map(lapTime -> Duration.ofMillis(Double.valueOf(lapTime * 1000).longValue()))
        .map(this::formatDuration)
        .collect(Collectors.toList());
  }

  public double raceTime() {
    return lapTimes.stream().mapToDouble(lap -> lap).sum();
  }

  public String readableRaceTime() {
    return formatDuration(Duration.ofMillis(Double.valueOf(raceTime() * 1000).longValue()));
  }

  public String formatDuration(Duration duration) {
    return String
        .format("%02d:%02d.%04d", duration.toMinutesPart(), duration.toSecondsPart(),
            duration.toMillisPart());
  }
}
