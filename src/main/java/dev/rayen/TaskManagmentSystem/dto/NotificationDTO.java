/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:34.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record NotificationDTO(

        @NotBlank(message = "message is required")
        String message,

        @NotBlank(message = "sender  is required")
        LocalDateTime senAt,

        @NotNull(message = "is required")
        boolean isRead
) {}

// TODO: for the next time