package com.aditya.DesignPattern.lld.googleDrive;

public class Demo {

    public static void main(String[] args) {
        User user1 = new User("abc@gmail.com", "John");
        User user2 = new User("abd@gmail.com", "John1");
        User user3 = new User("abe@gmail.com", "John2");

        Folder folder = new Folder("root", user1);

        Folder folder1 = new Folder("project", user1);
        File file = new File("Text1.txt", user1, "Abc");
        File file2 = new File("Text2.txt", user1, "Abd");

        folder1.addFileSystem(file2);

        folder.addFileSystem(file);
        folder.addFileSystem(folder1);

        file2.updateContent("Abc", user2);
        file2.updateContent("Abd", user1);

        file2.sharePermission(user1, user2, Permission.WRITE);

        file2.updateContent("Bcd", user2);

        System.out.println(file2.getContent(user2));
        System.out.println(file2.getVersionHistoryList());
        System.out.println(file2.getUserListForPermission(Permission.WRITE));

        System.out.println(folder.getFileSystems(user1));
    }
}
