package com.aditya.DesignPattern.lld.splitwise.group;

import com.aditya.DesignPattern.lld.splitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    List<Group> groupList;

    public GroupController() {
        this.groupList = new ArrayList<>();
    }

    public Group createGroup(String groupId, String groupName, User createdBy) {
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        group.addMembers(createdBy);

        groupList.add(group);

        return group;
    }

    public Group getGroup(String groupId) {
        return groupList.stream()
                .filter(group -> groupId.equals(group.getGroupId()))
                .findFirst()
                .orElse(null);
    }
}
