/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:18.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.service;

import dev.rayen.TaskManagmentSystem.dto.TaskDTO;
import dev.rayen.TaskManagmentSystem.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(TaskDTO taskDTO);
    Task assignTask(Long taskID, Long assignedToId);
    Task updateTask(Long taskID, TaskDTO taskDTO);
    void deleteTask(Long taskID);
    List<Task> getTaskByAssignedUser(Long userID);
    Task getTaskById(Long taskID);
}
