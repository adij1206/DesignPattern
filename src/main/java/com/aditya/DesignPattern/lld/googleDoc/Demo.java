package com.aditya.DesignPattern.lld.googleDoc;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        // Create User
        User user1 = new User("abc@gmail.com", "1234", "Aditya");
        User user2 = new User("abd@gmail.com", "1235", "Adi");
        User user3 = new User("abe@gmail.com", "1235", "Adit");
        User user4 = new User("abf@gmail.com", "1235", "Adity");

        // Create Document
        Document document = new Document(user1.getId());

        GoogleDocService googleDocService = new GoogleDocService();
        googleDocService.addUser(user2);
        googleDocService.addUser(user1);
        googleDocService.addUser(user3);
        googleDocService.addUser(user4);

        googleDocService.addDocument(document);

        System.out.println(googleDocService.validateUser("abc@gmail.com", "12345"));

        googleDocService.updateDocumentAccessLevel(document.getId(), user2.getId(), AccessLevel.NONE, user1.getId());
        googleDocService.updateDocumentAccessLevel(document.getId(), user3.getId(), AccessLevel.WRITE, user1.getId());
        googleDocService.updateDocumentAccessLevel(document.getId(), user4.getId(), AccessLevel.READ, user3.getId());
        googleDocService.updateDocumentAccessLevel(document.getId(), user3.getId(), AccessLevel.ADMIN, user2.getId());


        Thread abcd = new Thread(new Runnable() {
            @Override
            public void run() {
                googleDocService.updateDocumentContent("Abcd", document.getId(), user3.getId());
            }
        });

        Thread abce = new Thread(new Runnable() {
            @Override
            public void run() {
                googleDocService.updateDocumentContent("Abce", document.getId(), user1.getId());
            }
        });

        Thread abcf = new Thread(new Runnable() {
            @Override
            public void run() {
                googleDocService.updateDocumentContent("Abcf", document.getId(), user3.getId());
            }
        });

        abcd.start();
        abcf.start();
        abce.start();


        Thread.sleep(1000);
        System.out.println(googleDocService.getVersionHistoryByDocumentId(document.getId()));

        googleDocService.makeDocumentGlobal(document.getId(), user3.getId());
        googleDocService.makeDocumentGlobal(document.getId(), user1.getId());

        googleDocService.deleteDocument(document.getId(), user1.getId());
        googleDocService.deleteDocument(document.getId(), user4.getId());
    }
}
