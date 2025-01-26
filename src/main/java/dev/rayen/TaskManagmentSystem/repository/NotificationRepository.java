/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:14.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.repository;

import dev.rayen.TaskManagmentSystem.entity.Notification;
import dev.rayen.TaskManagmentSystem.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUser(user user);
}
