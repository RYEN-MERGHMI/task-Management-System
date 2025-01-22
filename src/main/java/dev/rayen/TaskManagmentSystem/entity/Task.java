/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:06.
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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id", nullable = false)  // Foreign key for assigned user
    private user assignedTo;

    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)  // Foreign key for creator user
    private user createdBy;
}
