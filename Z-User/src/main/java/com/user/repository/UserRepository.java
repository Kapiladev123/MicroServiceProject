package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.User;
/**
 * Repository interface for managing {@link User} entities.
 * <p>
 * This interface extends {@link JpaRepository}, indicating that it provides CRUD (Create, Read, Update, Delete)
 * operations for {@link User} entities with a primary key of type {@code Integer}.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    /**
     * This interface inherits methods for basic CRUD operations from {@link JpaRepository}.
     * Additional custom methods can be defined here if needed for specific data access requirements.
     * <p>
     * For example, additional methods might include finding users by their email address, or finding users
     * based on certain criteria related to their profile information.
     * <p>
     * Methods declared here should follow the naming convention supported by Spring Data JPA
     * to allow automatic query generation based on method names.
     * Custom query methods can also be annotated with {@link Query} to provide JPQL or SQL queries directly.
     */

}

