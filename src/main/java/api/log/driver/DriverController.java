package api.log.driver;

import api.log.drive.Drive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriverController {

  private final DriverService driverService;

  @GetMapping("/api/log/driver")
  public List<Driver> getAllDrivers() {
    return driverService.getAllDrivers();
  }

  @GetMapping(path = "/api/log/driver/name/{name}")
  public Driver getDriverByName(@PathVariable("name") String name) {
    return driverService.getDriverByName(name);
  }

  @GetMapping(path = "/api/log/driver/id/{id}")
  public Driver getDriverById(@PathVariable("id") Integer id) {
    return driverService.getDriverById(id);
  }

  @GetMapping("/api/log/driver")
  public List<Driver> getAllDriversOnDrive(@RequestBody Drive drive) {
    return driverService.getAllDriversOnDrive(drive);
  }

  @PostMapping("api/log/driver")
  public void addNewDriver(@RequestBody Driver driver) {
    driverService.addNewDriver(driver);
  }

  @PutMapping(path = "api/log/driver/{id}")
  public Driver updateDriver(@PathVariable("id") Integer id,
                             @RequestBody Driver driver) {
    return driverService.updateDriver(id, driver);
  }

}
