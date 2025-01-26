/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:13.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.repository;

import dev.rayen.TaskManagmentSystem.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);

    Optional<user>  findByUsername(String usernames);
}
