package dev.rayen.TaskManagmentSystem.exception;

public enum ErrorCode {

    // User-related errors
    USER_NOT_FOUND("USER_001", "User not found"),
    INVALID_ROLE("USER_002", "Invalid role provided"),
    DUPLICATE_EMAIL("USER_003", "Email already exists"),
    INVALID_CREDENTIALS("USER_004", "Invalid username or password"),

    // Task-related errors
    TASK_NOT_FOUND("TASK_001", "Task not found"),
    INVALID_DUE_DATE("TASK_002", "Due date must be in the future"),
    TASK_ASSIGNMENT_FAILED("TASK_003", "Failed to assign task to user"),

    // Notification-related errors
    NOTIFICATION_NOT_FOUND("NOTIFICATION_001", "Notification not found"),
    NOTIFICATION_SEND_FAILED("NOTIFICATION_002", "Failed to send notification"),

    // Generic errors
    INTERNAL_SERVER_ERROR("GENERIC_001", "Internal server error"),
    VALIDATION_ERROR("GENERIC_002", "Validation failed");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
