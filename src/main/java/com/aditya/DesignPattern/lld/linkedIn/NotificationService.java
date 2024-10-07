package com.aditya.DesignPattern.lld.linkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {

    private Map<String, Notification> notificationMap;

    public NotificationService() {
        this.notificationMap = new HashMap<>();
    }

    public void addNotification(Notification notification) {
        this.notificationMap.put(notification.getNotificationId(), notification);
    }

    public Notification getNotificationByNotificationId(String notificationId) {
        return this.notificationMap.get(notificationId);
    }

    public List<Notification> getNotificationListByUserId(String userId) {
        List<Notification> notificationList = new ArrayList<>();

        for (Notification notification : this.notificationMap.values()) {
            if (notification.getUserId().equals(userId)) {
                notificationList.add(notification);
            }
        }

        return notificationList;
    }

    public List<Notification> getNotificationListByUserIdAndType(String userId, NotificationType notificationType) {
        List<Notification> notificationList = new ArrayList<>();

        for (Notification notification : this.notificationMap.values()) {
            if (notification.getUserId().equals(userId) && notificationType.name().equals(notification.getType())) {
                notificationList.add(notification);
            }
        }

        return notificationList;
    }
}
