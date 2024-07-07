package com.user.service;

import java.util.List;

import com.user.model.User;

/**
 * Service interface for managing {@link User} entities.
 * <p>
 * This interface defines methods for performing CRUD (Create, Read, Update, Delete) operations on user entities.
 * Implementations of this interface are responsible for interacting with the underlying data access layer
 * (e.g., repository classes) to perform database operations.
 */
public interface UserService {

    /**
     * Saves a user entity to the database.
     *
     * @param user The user entity to be saved.
     * @return The saved user entity.
     */
    User saveUser(User user);

    /**
     * Retrieves all user entities from the database.
     *
     * @return A list containing all user entities.
     */
    List<User> getAllUser();

    /**
     * Retrieves a user entity from the database by its ID.
     *
     * @param userId The ID of the user entity to retrieve.
     * @return The user entity with the specified ID, or {@code null} if not found.
     */
    User getUser(int userId);
    
}

