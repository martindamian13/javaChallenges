package Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    String name;
    List<ZooArea> areas;

    public Zoo() {
        this.areas = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addArea(ZooArea area) {
        this.areas.add(area);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ZooArea> getAreas() {
        return this.areas;
    }


}


