/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:24.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.dto;

import dev.rayen.TaskManagmentSystem.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record userDTO(
        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 50, message = "Username should be between 3 and 50 characters")
        String username,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password should have at least 6 characters")
        String password,

        @NotBlank(message = "Role is required")
        String role
) {}