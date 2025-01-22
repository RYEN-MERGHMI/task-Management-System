/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:31.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskDTO(
        @NotBlank(message = "title is required")
        String title,

        @NotBlank(message = "description is required")
        String description,

        @NotBlank(message = "date is required")
        @Future(message = "Due date must be in the future")
        LocalDateTime dueDate,

        @NotNull(message = "Assigned user ID is required")
        Long assignedToId,

        @NotNull(message = "Creator user ID is required")
        Long createdById

) {}
