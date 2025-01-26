/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:14.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.repository;

import dev.rayen.TaskManagmentSystem.entity.Task;
import dev.rayen.TaskManagmentSystem.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssignedTo(user user);
}
