package api.log.event;

import api.log.EventType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "event")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer Id;

  @Column(name = "drive_id")
  private Integer driveID;

  @Column(name = "description")
  private String description;

  @Enumerated(EnumType.ORDINAL)
  @Column(name = "type")
  private EventType eventType;

  @Column(name = "lat")
  private String lat;

  @Column(name = "lon")
  private String lon;

  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();
  @Column(name = "synced_at")
  private LocalDateTime syncedAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Event event = (Event) o;
    return Id != null && Objects.equals(Id, event.Id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
