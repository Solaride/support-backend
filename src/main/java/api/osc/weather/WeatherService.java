package api.osc.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  private final WeatherRepository weatherRepository;

  @Autowired
  public WeatherService(WeatherRepository weatherRepository) {
    this.weatherRepository = weatherRepository;
  }

  public Weather getWeatherData() {
    //return weatherRepository.getLatestWeatherData();
    return weatherRepository.findFirstByOrderByIdDesc();
  }

  public void addWeatherData(Weather weather) {
    weatherRepository.save(weather);
  }

}
