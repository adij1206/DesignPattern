package com.aditya.DesignPattern.lld.googleDrive;

import java.util.ArrayList;
import java.util.List;

public class File extends FileSystem {

    private String content;
    private List<VersionHistory> versionHistoryList;
    private int version;

    public File(String name, User owner, String content) {
        super(name, owner);
        this.content = content;
        versionHistoryList = new ArrayList<>();
        this.version = 0;

        addVersionHistory(owner, content);
    }

    private synchronized void addVersionHistory(User owner, String content) {
        VersionHistory versionHistory = new VersionHistory(owner, content);
        versionHistoryList.add(versionHistory);
        this.version++;
    }

    public void updateContent(String content, User user) {
        Permission permission = getAccessController().getPermissionForUser(user);
        if (permission == null || permission.getPriority() < Permission.WRITE.getPriority()) {
            System.out.println("You don't have permission to write this file");
            return;
        }

        this.content = content;
        addVersionHistory(user, content);
    }

    public String getContent(User user) {
        Permission permission = getAccessController().getPermissionForUser(user);
        if (permission == null || permission.getPriority() < Permission.READ.getPriority()) {
            System.out.println("You don't have permission to read this file");
            return "";
        }
        return content;
    }

    public List<VersionHistory> getVersionHistoryList() {
        return versionHistoryList;
    }

    public int getVersion() {
        return version;
    }
}
