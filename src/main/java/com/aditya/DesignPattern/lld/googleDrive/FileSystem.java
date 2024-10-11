package com.aditya.DesignPattern.lld.googleDrive;

import java.util.List;
import java.util.UUID;

public abstract class FileSystem {

    private String id;
    private String name;
    private User owner;
    private AccessController accessController;


    public FileSystem(String name, User owner) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.owner = owner;
        this.accessController = new AccessController(owner);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public AccessController getAccessController() {
        return accessController;
    }

    public void sharePermission(User accessProvider, User accessGainer, Permission permission) {
        accessController.addPermissionForUser(accessProvider, accessGainer, permission);
    }

    public List<User> getUserListForPermission(Permission permission) {
        return accessController.getUserForPermission(permission);
    }
}
