package com.adamchilds.daycare.entity.roles.service;

import com.adamchilds.daycare.entity.roles.model.UserRole;
import org.springframework.scheduling.annotation.Async;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This service provides functionality for interfacing with user roles.
 *
 * @author Adam Childs
 */
public interface UserRoleService {

    /**
     * This method is responsible for creating the {@link UserRole}
     *
     * @param userRole The {@link UserRole} to deliver
     */
    @Async
    public void create(UserRole userRole);

    /**
     * Finds the given {@link UserRole} in the database.
     *
     * @param userRole The {@link UserRole} to find
     * @return The UserRole from the database
     */
    public UserRole find(UserRole userRole);

    /**
     * Returns this {@link UserRole}'s instance of EntityManager
     * @return an EntityManager tied to this UserRole instance
     */
    public EntityManager getEntityManager();

    /**
     * Return a specific {@link UserRole} from the database.
     *
     * @param objectId The id of the {@link UserRole} that we want to retrieve
     * @return The UserRole from the database
     */
    public UserRole read(Object objectId);

    /**
     * This method will return a list of all the {@link UserRole}'s in the database
     *
     * @return a list of all UserRoles
     */
    public List<UserRole> readAllUserRoles();

    /**
     * Reads all {@link UserRole}'s from the database that are associated with the specified userId
     *
     * @param userId the userId set on the User accounts we want to find
     * @return a List of {@link UserRole}'s with userId's matching the specified userId
     */
    public List<UserRole> readAllRolesByUserId(Long userId);

    /**
     *
     * @param userId
     * @param userRole
     * @return
     */
    public UserRole readUserRoleByUserIdAndUserRole(Long userId, String userRole);

    /**
     * Removes the specified {@link UserRole} from the database.
     *
     * @param userRole The {@link UserRole} to remove
     */
    @Async
    public void remove(UserRole userRole);

    /**
     * Updates the specified {@link UserRole} in the database.
     *
     * @param userRole The {@link UserRole} to update
     * @return The {@link UserRole} object that has been updated
     */
    @Async
    public Object update(UserRole userRole);

}