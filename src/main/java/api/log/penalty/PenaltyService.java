package api.log.penalty;

import api.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PenaltyService {

  private final PenaltyRepository penaltyRepository;

  public List<Penalty> getAllPenalties() {
    return penaltyRepository.findAll();
  }

  public Penalty getPenaltyById(Integer id) {
    return penaltyRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Penalty with id " + id + " does not exist"));
  }

  public void createPenalty(Penalty penalty) {
    penaltyRepository.save(penalty);
  }

  @Transactional
  public Penalty updatePenalty(Integer id, Penalty penalty) {
    Penalty penaltyToUpdate = penaltyRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Penalty with id " + id + " does not exist"));

    if (penalty.getSeconds() != null) {
      penaltyToUpdate.setSeconds(penalty.getSeconds());
    }

    if (penalty.getDriveId() != null) {
      penaltyToUpdate.setDriveId(penalty.getDriveId());
    }

    return penaltyRepository.save(penaltyToUpdate);
  }

  public void deletePenalty(Integer id) {
    boolean penaltyExists = penaltyRepository.existsById(id);

    if (!penaltyExists) {
      throw new NotFoundException("Penalty with id " + id + " does not exist");
    }

    penaltyRepository.deleteById(id);
  }
}
