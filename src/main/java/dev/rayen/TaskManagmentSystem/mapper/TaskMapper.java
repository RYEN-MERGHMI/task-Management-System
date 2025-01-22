/**
 * Made  by rayen.
 * Date: 22/01/2025.
 * Time: 10:51.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.mapper;

import dev.rayen.TaskManagmentSystem.dto.NotificationDTO;
import dev.rayen.TaskManagmentSystem.dto.TaskDTO;
import dev.rayen.TaskManagmentSystem.entity.Task;
import dev.rayen.TaskManagmentSystem.entity.user;

import static org.springframework.data.jpa.domain.AbstractAuditable_.createdBy;

public class TaskMapper {

    // convert task entity to taskdto
    public static TaskDTO toDto(Task task){
        if(task == null){
            return null;
        }
        return new TaskDTO(
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getAssignedTo().getId(),
                task.getCreatedBy().getId()
        );
    }

    // convert taskDto to task entity

    public static Task toEntity(TaskDTO taskDTO, user assignedTo, user createdBy){
        if(taskDTO == null){
            return null;
        }

        Task task = new Task();
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setDueDate(taskDTO.dueDate());
        task.setAssignedTo(assignedTo);  // Setting the assignedTo User
        task.setCreatedBy(createdBy);  // Setting the createdBy User

        return task;
    }
}
