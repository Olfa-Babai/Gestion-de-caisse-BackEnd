package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.AdmUserProfile;
import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;

import java.util.List;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void deleteRole(Long id);
    AdmUserProfile addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
    List<Role> getRolesOfUser(Long id);
	void deleteUser(Long id);
	User updateUser(Long id, User userU);
	User searchUser(String matricule);
	List<User> searching(String s);
	List<User> sortUsers(String s);
	User uexists(String login, String pwd);
	boolean check(Long id, String s);
}
