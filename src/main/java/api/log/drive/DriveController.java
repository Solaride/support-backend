package api.log.drive;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DriveController {

  private final DriveService driveService;

  @GetMapping("api/log/drive")
  public List<Drive> getAllDrives() {
    return driveService.getAllDrives();
  }

  @GetMapping("api/log/drive/current")
  public Drive getCurrentDrive() {
    return driveService.getCurrentDrive();
  }

  @PostMapping("api/log/drive")
  public void createDrive(@RequestBody Drive drive) {
    driveService.createDrive(drive);
  }

}
