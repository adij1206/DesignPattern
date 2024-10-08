package com.aditya.DesignPattern.lld.googleDoc;

import java.util.List;

public class GoogleDocService {

    private UserService userService;
    private DocumentService documentService;
    private VersionHistoryService versionHistoryService;
    private DocumentAccessService documentAccessService;

    public GoogleDocService() {
        this.userService = new UserService();
        this.documentAccessService = new DocumentAccessService();
        this.versionHistoryService = new VersionHistoryService();
        this.documentService = new DocumentService();
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    public boolean validateUser(String id, String password) {
        return userService.validateUser(id, password);
    }

    public void createAndAddVersionHistory(int history, String content, String userId, String documentId) {
        versionHistoryService.createAndAddVersionHistory(history, content, userId, documentId);
    }

    public VersionHistory getVersionHistoryById(String id) {
        return versionHistoryService.getVersionHistoryById(id);
    }

    public List<VersionHistory> getVersionHistoryByDocumentId(String documentId) {
        return versionHistoryService.getVersionHistoryByDocumentId(documentId);
    }

    public void addDocument(Document document) {
        documentService.addDocument(document);
        documentAccessService.addDocument(document.getId(), document.getOwner());
    }

    public Document getDocumentByDocumentIdAndUSerId(String documentId, String userId) {
        DocumentAccess documentAccessByDocumentIdAndUserId = documentAccessService.getDocumentAccessByDocumentIdAndUserId(
                documentId, userId);

        if (documentAccessByDocumentIdAndUserId.getAccessLevel().equals(AccessLevel.NONE.name())) {
            return null;
        }

        return documentService.getDocumentById(documentId);
    }

    public void updateDocumentContent(String content, String documentId, String userId) {
        DocumentAccess documentAccessByDocumentIdAndUserId = documentAccessService.getDocumentAccessByDocumentIdAndUserId(
                documentId, userId);

        if (documentAccessByDocumentIdAndUserId.getAccessLevel().equals(
                AccessLevel.WRITE.name()) || documentAccessByDocumentIdAndUserId.getAccessLevel().equals(
                AccessLevel.ADMIN.name())) {
            Document document = documentService.updateDocumentContent(content, documentId);
            versionHistoryService.createAndAddVersionHistory(
                    document.getLatestVersionHistory(), content, userId, documentId);
            System.out.println("Updating the Document by user" + userId);
            return;
        }

        System.out.println("Document Update Failed for " + userId);
    }

    public void makeDocumentGlobal(String documentId, String userId) {
        DocumentAccess documentAccessByDocumentIdAndUserId = documentAccessService.getDocumentAccessByDocumentIdAndUserId(
                documentId, userId);

        if (documentAccessByDocumentIdAndUserId.getAccessLevel().equals(AccessLevel.ADMIN.name())) {
            System.out.println("Making the Document Public by user" + userId);
            documentService.makeDocumentGlobal(documentId);
            return;
        }

        System.out.println("Making the Document Opertaion Failed" + userId);
    }

    public void deleteDocument(String documentId, String userId) {
        DocumentAccess documentAccessByDocumentIdAndUserId = documentAccessService.getDocumentAccessByDocumentIdAndUserId(
                documentId, userId);

        if (documentAccessByDocumentIdAndUserId.getAccessLevel().equals(AccessLevel.ADMIN.name())) {
            documentService.deleteDocument(documentId);
            System.out.println("Deleting the Document by user" + userId);
            return;
        }

        System.out.println("Deleting the Document Opertaion Failed" + userId);
    }

    public synchronized void updateDocumentAccessLevel(
            String documentId, String userId, AccessLevel accessLevel, String changerUserId
    ) {
        DocumentAccess documentAccess = documentAccessService.getDocumentAccessByDocumentIdAndUserId(
                documentId, changerUserId);

        if (AccessLevel.WRITE.name().equals(documentAccess.getAccessLevel()) &&
                (accessLevel.equals(AccessLevel.WRITE) || accessLevel.equals(AccessLevel.READ) || accessLevel.equals(
                        AccessLevel.NONE))) {
            System.out.println("Updating the Access Level of user" + userId);
            documentAccessService.updateDocumentAccessLevel(documentId, userId, accessLevel);
        } else if (AccessLevel.READ.name().equals(documentAccess.getAccessLevel()) &&
                (accessLevel.equals(AccessLevel.READ) || accessLevel.equals(AccessLevel.NONE))) {
            documentAccessService.updateDocumentAccessLevel(documentId, userId, accessLevel);
            System.out.println("Updating the Access Level of user" + userId);
        } else if (AccessLevel.ADMIN.name().equals(documentAccess.getAccessLevel()) &&
                (accessLevel.equals(AccessLevel.ADMIN) || accessLevel.equals(AccessLevel.WRITE) || accessLevel.equals(
                        AccessLevel.READ) || accessLevel.equals(AccessLevel.NONE))) {
            documentAccessService.updateDocumentAccessLevel(documentId, userId, accessLevel);
            System.out.println("Updating the Access Level of user" + userId);
        }
    }
}
