package com.aditya.DesignPattern.lld.googleDrive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessController {

    private Map<User, Permission> userPermissionMap;

    public AccessController(User owner) {
        userPermissionMap = new HashMap<>();
        userPermissionMap.put(owner, Permission.ADMIN);
    }

    public void addPermissionForUser(User accessProvider, User user, Permission permission) {
        Permission existingPermission = userPermissionMap.get(accessProvider);
        if (permission == null || existingPermission.getPriority() < permission.getPriority()) {
            System.out.println("Access Provider cannot provide you the access");
            return;
        }

        userPermissionMap.put(user, permission);
    }

    public Permission getPermissionForUser(User user) {
        return userPermissionMap.get(user);
    }

    public List<User> getUserForPermission(Permission permission) {
        List<User> users = new ArrayList<>();
        for (User user : userPermissionMap.keySet()) {
            if (userPermissionMap.get(user).getPriority()>=permission.getPriority()) {
                users.add(user);
            }
        }

        return users;
    }
}
