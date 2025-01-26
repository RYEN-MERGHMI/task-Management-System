/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:18.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.service;

import dev.rayen.TaskManagmentSystem.dto.userDTO;
import dev.rayen.TaskManagmentSystem.entity.user;

public interface UserService {

    user registerUser(userDTO userDTO);
    user loginUser(String usernames, String password);
    user getUserById(Long id);
}
