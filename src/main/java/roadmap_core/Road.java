package roadmap_core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Road implements Serializable {

  private List<Node> nodes;


}
