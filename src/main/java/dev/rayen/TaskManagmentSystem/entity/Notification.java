/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:09.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime sentAt;
    private boolean isRead;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // Foreign key for the user receiving the notification
    private user user;
}
