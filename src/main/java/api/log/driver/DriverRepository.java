package api.log.driver;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

  Optional<Driver> getDriverByName(String name);

  Optional<List<Driver>> getDriversByDriveId(Integer driveId);

}
