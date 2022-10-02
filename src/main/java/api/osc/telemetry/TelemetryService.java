package api.osc.telemetry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelemetryService {

  private final TelemetryRepository telemetryRepository;

  @Autowired
  public TelemetryService(TelemetryRepository telemetryRepository) {
    this.telemetryRepository = telemetryRepository;
  }

  public void addTelemetryData(Telemetry telemetry) {
    telemetryRepository.save(telemetry);
  }

  public Telemetry getTelemetryData() {
    return telemetryRepository.findFirstByOrderByIdDesc();
  }
}
