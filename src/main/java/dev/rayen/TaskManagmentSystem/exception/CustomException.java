/**
 * Made  by rayen.
 * Date: 26/01/2025.
 * Time: 10:02.
 * Project Name : TaskManagmentSystem.
 */

package dev.rayen.TaskManagmentSystem.exception;

import ch.qos.logback.core.spi.ErrorCodes;

public class CustomException extends RuntimeException{


    private final ErrorCode errorCode;

    // Constructor with ErrorCode and custom message
    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    // Constructor with only ErrorCode (uses default message from enum)
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
