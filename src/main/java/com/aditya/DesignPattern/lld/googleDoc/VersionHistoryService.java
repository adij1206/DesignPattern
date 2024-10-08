package com.aditya.DesignPattern.lld.googleDoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VersionHistoryService {

    private Map<String, VersionHistory> versionHistoryMap;

    public VersionHistoryService() {
        versionHistoryMap = new HashMap<>();
    }

    public void createAndAddVersionHistory(int history, String content, String userId, String documentId) {
        VersionHistory versionHistory = new VersionHistory(history, content, userId, documentId);

        versionHistoryMap.put(versionHistory.getId(), versionHistory);
    }

    public VersionHistory getVersionHistoryById(String id) {
        return versionHistoryMap.get(id);
    }

    public List<VersionHistory> getVersionHistoryByDocumentId(String documentId) {
        List<VersionHistory> versionHistories = new ArrayList<>();
        for (VersionHistory versionHistory : versionHistoryMap.values()) {
            if (versionHistory.getDocumentId().equals(documentId)) {
                versionHistories.add(versionHistory);
            }
        }

        return versionHistories;
    }
}
