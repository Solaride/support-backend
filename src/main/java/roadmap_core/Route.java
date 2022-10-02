package roadmap_core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Route implements Serializable {

  //TODO: map to roadmap info
  private List<Road> roads;

  public Route(List<Road> roads) {
    this.roads = roads;
  }

}
