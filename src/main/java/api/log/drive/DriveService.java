package api.log.drive;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriveService {

  private final DriveRepository driveRepository;

  public List<Drive> getAllDrives() {
    return driveRepository.findAll();
  }

  public Drive getCurrentDrive() {
    return driveRepository.findFirstByOrderByIdDesc();
  }

  public void createDrive(Drive drive) {
    driveRepository.save(drive);
  }
}
