package api.log.penalty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class Penalty {

  @Id
  @GeneratedValue
  private Integer id;
  private Integer driveId;
  private Integer seconds;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime syncedAt;

}
