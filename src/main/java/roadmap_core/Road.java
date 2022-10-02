package roadmap_core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Road implements Serializable {

  //TODO: map to roadmap info
  private List<Node> nodes;


}
