package api.log.drive;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "drive")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Drive {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "route_id")
  private Integer routeId;

  @Column(name = "name")
  private String name;

  @Column(name = "start")
  private LocalDateTime start;

  @Column(name = "end")
  private LocalDateTime end;

  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
  @Column(name = "synced_at")
  private LocalDateTime syncedAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Drive drive = (Drive) o;
    return id != null && Objects.equals(id, drive.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
