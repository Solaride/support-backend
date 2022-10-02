package api.log.driver;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Driver {

  @Id
  private Integer id;
  private int driveId;

  private Integer weight;
  private String name;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime syncedAt;

}
