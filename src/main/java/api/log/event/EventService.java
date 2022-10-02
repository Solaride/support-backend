package api.log.event;

import api.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

  private final EventRepository eventRepository;

  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  public Event getEventById(Integer id) {
    return eventRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Event with id " + id + " not found"));
  }

  public void createNewEvent(Event event) {
    eventRepository.save(event);
  }

  public Event updateEvent(Integer id, Event event) {
    Event eventToUpdate = eventRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Event with id " + id + " does not exist"));

    if (event.getEventType() != null) {
      eventToUpdate.setEventType(event.getEventType());
    }

    if (event.getDescription() != null) {
      eventToUpdate.setDescription(event.getDescription());
    }

    if (event.getLat() != null) {
      eventToUpdate.setLat(event.getLat());
    }

    if (event.getLon() != null) {
      eventToUpdate.setLon(event.getLon());
    }

    if (event.getDriveID() != null) {
      eventToUpdate.setDriveID(event.getDriveID());
    }

    return eventRepository.save(eventToUpdate);
  }

  public void deleteEvent(Integer id) {
    boolean eventExists = eventRepository.existsById(id);

    if (!eventExists) {
      throw new NotFoundException("Event with id " + id + " does not exist");
    }

    eventRepository.deleteById(id);

  }
}
