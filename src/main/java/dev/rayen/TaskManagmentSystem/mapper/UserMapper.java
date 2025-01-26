/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:43.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.mapper;

import dev.rayen.TaskManagmentSystem.dto.userDTO;
import dev.rayen.TaskManagmentSystem.entity.Role;
import dev.rayen.TaskManagmentSystem.entity.user;
import dev.rayen.TaskManagmentSystem.exception.CustomException;
import dev.rayen.TaskManagmentSystem.exception.ErrorCode;

public class UserMapper {

    // Convert User entity to userDTO
    public static userDTO toDTO(user user) {
        if (user == null) {
            return null;  // Return null if the entity is null
        }
        return new userDTO(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().name() // Convert Role enum to String
        );
    }

    // Convert userDTO to User entity
    public static user toEntity(userDTO userDto) {
        if (userDto == null) {
            return null; // Return null if the DTO is null
        }
        user user = new user();
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());

        // Safely handle the conversion from String to Role enum
        Role role = convertToRole(userDto.role());
        if (role != null) {
            user.setRole(role);
        } else {
            // Handle invalid role string
            throw new IllegalArgumentException("Invalid role: " + userDto.role());
        }

        return user;
    }

    // Safely convert String to Role enum
    private static Role convertToRole(String roleString) {
        try {
            return Role.valueOf(roleString.toUpperCase()); // Convert the string to enum (case-insensitive)
        } catch (IllegalArgumentException e) {
            throw  new CustomException(ErrorCode.INVALID_ROLE, "invalid role" + roleString);
        }
    }
}
