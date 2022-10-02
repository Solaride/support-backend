package api.log.driver;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "driver")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Driver {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "drive_id")
  private Integer driveId;

  @Column(name = "weight")
  private Integer weight;

  @Column(name = "name")
  private String name;

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
    Driver driver = (Driver) o;
    return id != null && Objects.equals(id, driver.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
