package api.osc.weather;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "weather")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Weather {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "time")
  private LocalDateTime time = LocalDateTime.now();

  @Column(name = "wind_speed")
  private float windSpeed;

  @Column(name = "wind_direction")
  private float windDirection;

  @Column(name = "solar_intensity")
  private float solarIntensity;

  @Column(name = "air_temperature")
  private float airTemperature;

  @Column(name = "air_pressure")
  private float airPressure;

  @Column(name = "air_humidity")
  private float airHumidity;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Weather weather = (Weather) o;
    return id != null && Objects.equals(id, weather.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
