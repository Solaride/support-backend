package api.osc.telemetry;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Telemetry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "time")
  private LocalDateTime time = LocalDateTime.now();

  @Column(name = "battery_temp")
  private float batteryTemperature;
  @Column(name = "battery_voltage")
  private float batteryVoltage;
  @Column(name = "bms_temp")
  private float BMSTemperature;

  @Column(name = "left_motor_rpm")
  private float leftMotorRPM;
  @Column(name = "left_motor_current")
  private float leftMotorCurrent;
  @Column(name = "left_motor_temp")
  private float leftMotorTemperature;

  @Column(name = "right_motor_rpm")
  private float rightMotorRPM;
  @Column(name = "right_motor_current")
  private float rightMotorCurrent;
  @Column(name = "right_motor_temp")
  private float rightMotorTemperature;

  @Column(name = "solar_charging")
  private float solarCharging;  // sus

  @Column(name = "cabin_temp")
  private float cabinTemperature;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Telemetry telemetry = (Telemetry) o;
    return id != null && Objects.equals(id, telemetry.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
