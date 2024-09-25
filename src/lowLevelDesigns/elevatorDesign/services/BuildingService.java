package lowLevelDesigns.elevatorDesign.services;

import lowLevelDesigns.elevatorDesign.models.Building;
import lowLevelDesigns.elevatorDesign.models.Floor;

import java.util.List;

public class BuildingService {
    Building building;

    public BuildingService(List<Floor> floorList) {
        this.building = new Building(floorList);
    }

    public void addFloor(Floor floor) {
        building.floorList.add(floor);
    }

    public void removeFloor(Floor floor) {
        building.floorList.remove(floor);
    }

    public List<Floor> getFloors() {
        return building.getFloorList();
    }
}
