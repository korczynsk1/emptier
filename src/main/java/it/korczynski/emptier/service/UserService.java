package it.korczynski.emptier.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import it.korczynski.emptier.service.to.UserProfileTO;


/**
 * @author MAKORCZY
 *	TODO JAVADOCS
 */
public interface UserService {
	
	public UserProfileTO updateUser(UserProfileTO userTo);
	
	public UserProfileTO createUser(UserProfileTO userTo) throws EntityExistsException;
	
	public void deleteUser(Long id);
	
	public UserProfileTO findUserProfileByLogin(String login) throws EntityNotFoundException;
	
	public List<UserProfileTO> findUsers(String login, String name, String surname);

}
