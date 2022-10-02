package api.osc;


import api.osc.telemetry.Telemetry;
import api.osc.telemetry.TelemetryService;
import api.osc.weather.Weather;
import api.osc.weather.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OSCDataController {

  private final TelemetryService telemetryService;
  private final WeatherService weatherService;

  @GetMapping("/api/osc/weather")
  public Weather getWeatherData() {
    return weatherService.getWeatherData();
  }

  @GetMapping("/api/osc/telemetry")
  public Telemetry getTelemetryData() {
    return telemetryService.getTelemetryData();
  }

  @PostMapping("/api/osc/weather")
  public void addWeatherData(@RequestBody Weather weather) {
    weatherService.addWeatherData(weather);
  }

  @PostMapping("/api/osc/telemetry")
  public void addTelemetryData(@RequestBody Telemetry telemetry) {
    telemetryService.addTelemetryData(telemetry);
  }

}
