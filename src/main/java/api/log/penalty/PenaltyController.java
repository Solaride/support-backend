package api.log.penalty;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PenaltyController {

  private final PenaltyService penaltyService;

  @GetMapping("/api/log/penalty")
  public List<Penalty> getAllPenalties() {
    return penaltyService.getAllPenalties();
  }

  @GetMapping("/api/log/penalty/{id}")
  public Penalty getPenaltyById(@PathVariable("id") Integer id) {
    return penaltyService.getPenaltyById(id);
  }

  @PostMapping("/api/log/penalty")
  public void createPenalty(@RequestBody Penalty penalty) {
    penaltyService.createPenalty(penalty);
  }

  @PutMapping("/api/log/penalty/{id}")
  public Penalty updatePenalty(@PathVariable("id") Integer id,
                               @RequestBody Penalty penalty) {
    return penaltyService.updatePenalty(id, penalty);
  }

  @DeleteMapping("/api/log/penalty/{id}")
  public void deletePenalty(@PathVariable("id") Integer id) {
    penaltyService.deletePenalty(id);
  }

}
