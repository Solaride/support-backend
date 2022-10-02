package api.log.event;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

  private final EventService eventService;

  @GetMapping("/api/log/event")
  public List<Event> getAllEvents() {
    return eventService.getAllEvents();
  }

  @GetMapping("/api/log/event/id/{id}")
  public Event getEventById(@PathVariable("id") Integer id) {
    return eventService.getEventById(id);
  }

  @PostMapping("/api/log/event")
  public void createNewEvent(@RequestBody Event event) {
    eventService.createNewEvent(event);
  }

  @PutMapping("/api/log/event/{id}")
  public Event updateEvent(@PathVariable("id") Integer id,
                           @RequestBody Event event) {
    return eventService.updateEvent(id, event);
  }

  @DeleteMapping("/api/log/event/{id}")
  public void deleteEvent(@PathVariable Integer id) {
    eventService.deleteEvent(id);
  }
}
