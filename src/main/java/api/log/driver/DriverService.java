package api.log.driver;

import api.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DriverService {

  private final DriverRepository driverRepository;

  public List<Driver> getAllDrivers() {
    return driverRepository.findAll();
  }

  public Driver getDriverByName(String name) {
    return driverRepository.getDriverByName(name)
            .orElseThrow(() -> new NotFoundException("Driver with name " + name + " does not exist"));
  }

  public Driver getDriverById(Integer id) {
    return driverRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Driver with id " + id + " does not exist"));
  }

  public List<Driver> getAllDriversOnDrive(Integer id) {
    return driverRepository.getDriversByDriveId(id)
            .orElseThrow(() -> new NotFoundException("No drivers on drive or drive with id " + id + " not found"));
  }

  public void addNewDriver(Driver driver) {
    driverRepository.save(driver);
  }

  @Transactional
  public Driver updateDriver(Integer id, Driver driver) {

    Driver driverToUpdate = driverRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Driver with id " + id + " does not exist"));

    if (driver.getName() != null) {
      driverToUpdate.setName(driver.getName());
    }

    if (driver.getWeight() != null) {
      driverToUpdate.setWeight(driver.getWeight());
    }

    if (driver.getDriveId() != null) {
      driverToUpdate.setDriveId(driver.getDriveId());
    }

    driverToUpdate.setUpdatedAt(LocalDateTime.now());

    return driverRepository.save(driverToUpdate);
  }
}
