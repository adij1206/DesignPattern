package com.aditya.DesignPattern.lld.googleDrive;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystem {

    private List<FileSystem> fileSystems;

    public Folder(String name, User owner) {
        super(name, owner);
        this.fileSystems = new ArrayList<>();
    }

    public void addFileSystem(FileSystem fileSystem) {
        User user = fileSystem.getOwner();
        Permission permissionForUser = getAccessController().getPermissionForUser(user);

        if (permissionForUser == null || permissionForUser.getPriority() < Permission.WRITE.getPriority()) {
            System.out.println("You do not have permission to write this folder");
            return;
        }

        this.fileSystems.add(fileSystem);
    }

    public List<FileSystem> getFileSystems(User user) {
        Permission permissionForUser = getAccessController().getPermissionForUser(user);

        if (permissionForUser == null || permissionForUser.getPriority() < Permission.WRITE.getPriority()) {
            System.out.println("You do not have permission to read this folder");
            return new ArrayList<>();
        }

        return this.fileSystems;
    }
}
