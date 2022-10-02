package api.log.drive;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Drive {

  @Id
  @GeneratedValue
  private Integer id;
  private Integer routeId;
  private String name;
  private LocalDateTime start;
  private LocalDateTime end;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime syncedAt;

}
