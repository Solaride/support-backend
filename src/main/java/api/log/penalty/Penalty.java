package api.log.penalty;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "penalty")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Penalty {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "drive_id")
  private Integer driveId;

  @Column(name = "seconds")
  private Integer seconds;

  @Column(name = "synced_at")
  private LocalDateTime syncedAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Penalty penalty = (Penalty) o;
    return id != null && Objects.equals(id, penalty.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
