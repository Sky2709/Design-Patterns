package lowLevelDesigns.splitWise.controllers;

import lowLevelDesigns.splitWise.models.Group;
import lowLevelDesigns.splitWise.models.User;
import lowLevelDesigns.splitWise.services.GroupService;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    GroupService groupService= new GroupService();

    public void createNewGroup(String groupId, String groupName, User createdByUser) {
        groupService.createNewGroup(groupId, groupName, createdByUser);
    }

    public Group getGroup(String groupId){
        return groupService.getGroup(groupId);
    }

}
