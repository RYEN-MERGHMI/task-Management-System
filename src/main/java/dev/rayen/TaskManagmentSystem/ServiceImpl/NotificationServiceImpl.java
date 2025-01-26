/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 11:05.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.ServiceImpl;

import dev.rayen.TaskManagmentSystem.dto.NotificationDTO;
import dev.rayen.TaskManagmentSystem.entity.Notification;
import dev.rayen.TaskManagmentSystem.entity.user;
import dev.rayen.TaskManagmentSystem.exception.CustomException;
import dev.rayen.TaskManagmentSystem.exception.ErrorCode;
import dev.rayen.TaskManagmentSystem.mapper.NotificationMapper;
import dev.rayen.TaskManagmentSystem.repository.NotificationRepository;
import dev.rayen.TaskManagmentSystem.repository.UserRepository;
import dev.rayen.TaskManagmentSystem.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public Notification sendNotification(NotificationDTO notificationDTO) {
        // Fetch the user who will receive the notification
        user user = userRepository.findById(notificationDTO.userId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        // Convert NotificationDTO to Notification entity
        Notification notification = notificationMapper.toEntity(notificationDTO, user);

        // Save the notification to the database
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByUser(Long userId) {
        // Fetch the user from the database
        user user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        // Fetch all notifications for the user
        return notificationRepository.findByUser(user);
    }

    @Override
    public void markNotificationAsRead(Long notificationId) {
        // Fetch the notification from the database
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOTIFICATION_NOT_FOUND));

        // Mark the notification as read
        notification.setRead(true);

        // Save the updated notification to the database
        notificationRepository.save(notification);

    }
}
