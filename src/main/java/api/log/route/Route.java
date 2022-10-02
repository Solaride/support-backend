package api.log.route;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route")
@Getter
@Setter
public class Route {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "roads")
  private roadmap_core.Route roads;

  @Column(name = "roads_original")
  private roadmap_core.Route roadsOriginal;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
  @Column(name = "synced_at")
  private LocalDateTime syncedAt;

}
