/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:40.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.ServiceImpl;

import dev.rayen.TaskManagmentSystem.dto.TaskDTO;
import dev.rayen.TaskManagmentSystem.entity.Task;
import dev.rayen.TaskManagmentSystem.entity.user;
import dev.rayen.TaskManagmentSystem.exception.CustomException;
import dev.rayen.TaskManagmentSystem.exception.ErrorCode;
import dev.rayen.TaskManagmentSystem.mapper.TaskMapper;
import dev.rayen.TaskManagmentSystem.repository.TaskRepository;
import dev.rayen.TaskManagmentSystem.repository.UserRepository;
import dev.rayen.TaskManagmentSystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public Task createTask(TaskDTO taskDTO) {
        // Fetch the creator and assigned user form the database

        user createdBy = userRepository.findById(taskDTO.createdById())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        user assignedTo = userRepository.findById(taskDTO.assignedToId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        // convert TaskDTO to Task entity
        Task task = TaskMapper.toEntity(taskDTO, assignedTo, createdBy);

        // save the updated task to the database
        task.setAssignedTo(assignedTo);

        return taskRepository.save(task);
    }

    @Override
    public Task assignTask(Long taskID, Long assignedToId) {

        // fetch the task and assigned user from the database
        Task task = taskRepository.findById(taskID)
                .orElseThrow(() -> new CustomException(ErrorCode.TASK_NOT_FOUND));
        user assignedTo = userRepository.findById(assignedToId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        // assign the task to the user
        task.setAssignedTo(assignedTo);

        // save the updated task to the database
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskID, TaskDTO taskDTO) {
        // Fetch the task from the database
        Task task = taskRepository.findById(taskID)
                .orElseThrow(() -> new CustomException(ErrorCode.TASK_NOT_FOUND));

        // Update the task fields
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setDueDate(taskDTO.dueDate());

        // Save the updated task to the database
        return taskRepository.save(task);

    }

    @Override
    public void deleteTask(Long taskID) {
        // Fetch the task from the database
        Task task = taskRepository.findById(taskID)
                .orElseThrow(() -> new CustomException(ErrorCode.TASK_NOT_FOUND));

        // Delete the task
        taskRepository.delete(task);
    }

    @Override
    public List<Task> getTaskByAssignedUser(Long userID) {
        // Fetch the user from the database
        user user = userRepository.findById(userID)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        // Fetch all tasks assigned to the user
        return taskRepository.findByAssignedTo(user);
    }

    @Override
    public Task getTaskById(Long taskID) {
        // fetch the task from the database
        return taskRepository.findById(taskID)
                .orElseThrow(() -> new CustomException(ErrorCode.TASK_NOT_FOUND));
    }
}
