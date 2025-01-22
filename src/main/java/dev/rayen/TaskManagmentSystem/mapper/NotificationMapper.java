/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:52.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.mapper;

import dev.rayen.TaskManagmentSystem.dto.NotificationDTO;
import dev.rayen.TaskManagmentSystem.entity.Notification;
import dev.rayen.TaskManagmentSystem.entity.user;

public class NotificationMapper {

    // Convert Notification entity to NotificationDTO
    public static NotificationDTO toDTO(Notification notification) {
        if (notification == null) {
            return null;  // Return null if the entity is null
        }

        return new NotificationDTO(
                notification.getMessage(),
                notification.getSentAt(),
                notification.isRead()
        );
    }

    // Convert NotificationDTO to Notification entity
    public static Notification toEntity(NotificationDTO notificationDTO, user user) {  // Use User instead of user
        if (notificationDTO == null) {
            return null; // Return null if the DTO is null
        }

        Notification notification = new Notification();
        notification.setMessage(notificationDTO.message());
        notification.setSentAt(notificationDTO.senAt());
        notification.setRead(notificationDTO.isRead());
        notification.setUser(user); // Assuming you have the User object from the ID or context

        return notification;
    }
}
