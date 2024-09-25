package lowLevelDesigns.elevatorDesign.controllers;

import lowLevelDesigns.elevatorDesign.models.Floor;
import lowLevelDesigns.elevatorDesign.services.BuildingService;

import java.util.List;

public class BuildingController {
    private BuildingService buildingService;

    public BuildingController(List<Floor> floorList) {
        this.buildingService = new BuildingService(floorList);
    }

    public void addFloor(Floor floor) {
        buildingService.addFloor(floor);
    }

    public void removeFloor(Floor floor) {
        buildingService.removeFloor(floor);
    }

    public List<Floor> getFloors() {
        return buildingService.getFloors();
    }
}
