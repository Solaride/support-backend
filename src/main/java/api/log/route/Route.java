package api.log.route;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table
public class Route {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;

  //private Route roads;

  //private Route roadsOriginal;


  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime syncedAt;

}
