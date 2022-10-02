package api.log.route;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RouteController {

  private final RouteService routeService;

  @GetMapping("/api/log/route")
  public List<Route> getAllRoutes() {
    return routeService.getAllRoutes();
  }

  @GetMapping("/api/log/route/{id}")
  public Route getRouteById(@PathVariable("id") Integer id) {
    return routeService.getRouteById(id);
  }

  @PostMapping("/api/log/route")
  public void createRoute(@RequestBody Route route) {
    routeService.createRoute(route);
  }

  @PutMapping("/api/log/route/{id}")
  public Route updateRoute(@PathVariable("id") Integer id,
                           @RequestBody Route route) {
    return routeService.updateRoute(id, route);
  }

  @DeleteMapping("/api/log/route/{id}")
  public void deleteRoute(@PathVariable("id") Integer id) {
    routeService.deleteRoute(id);
  }

}
