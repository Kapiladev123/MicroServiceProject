package com.user.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an API response with a message, status, and HTTP status.
 * <p>
 * This class is annotated with {@code @Data} from Lombok, which automatically generates getters, setters,
 * {@code toString}, {@code equals}, and {@code hashCode} methods for its fields.
 * <p>
 * The {@code @AllArgsConstructor} annotation generates a constructor with all arguments,
 * and the {@code @NoArgsConstructor} annotation generates a constructor with no arguments.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    /**
     * The message included in the API response.
     */
    private String message;

    /**
     * The status indicating the success or failure of the API operation.
     */
    private boolean status;

    /**
     * The HTTP status of the API response.
     */
    private HttpStatus httpStatus;
}

