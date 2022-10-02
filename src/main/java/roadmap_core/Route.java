package roadmap_core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Route implements Serializable {

  private List<Road> roads;

  public Route(List<Road> roads) {
    this.roads = roads;
  }

}
