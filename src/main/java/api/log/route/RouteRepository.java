package api.log.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
