/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:18.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.service;

import dev.rayen.TaskManagmentSystem.dto.NotificationDTO;
import dev.rayen.TaskManagmentSystem.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification sendNotification(NotificationDTO notificationDTO);
    List<Notification> getNotificationsByUser(Long userId);
    void markNotificationAsRead(Long notificationId);
}
