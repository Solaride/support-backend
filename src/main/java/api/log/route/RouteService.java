package api.log.route;

import api.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

  private final RouteRepository routeRepository;

  public List<Route> getAllRoutes() {
    return routeRepository.findAll();
  }


  public Route getRouteById(Integer id) {
    return routeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Route with id " + id + " does not exist"));
  }

  public void createRoute(Route route) {
    routeRepository.save(route);
  }

  public Route updateRoute(Integer id, Route route) {

    Route routeToUpdate = routeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Route with id " + id + " does not exits"));

    if (route.getRoads() != null) {
      routeToUpdate.setRoads(route.getRoads());
    }

    if (route.getName() != null) {
      routeToUpdate.setName(route.getName());
    }

    if (route.getRoadsOriginal() != null) {
      routeToUpdate.setRoadsOriginal(route.getRoadsOriginal());
    }

    routeToUpdate.setUpdatedAt(LocalDateTime.now());

    return routeRepository.save(routeToUpdate);
  }

  public void deleteRoute(Integer id) {

    boolean routeExists = routeRepository.existsById(id);

    if (!routeExists) {
      throw new NotFoundException("Route with id " + id + " does not exist");
    }

    routeRepository.deleteById(id);

  }
}
