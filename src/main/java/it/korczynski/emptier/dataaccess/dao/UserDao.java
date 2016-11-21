package it.korczynski.emptier.dataaccess.dao;

import java.util.List;

import it.korczynski.emptier.dataaccess.entities.UserEntity;

/**
 * Data Access Object for retrieving User data.
 * 
 */
public interface UserDao extends Dao<UserEntity, Long> {

	/**
	 * Finds a user by login.
	 * 
	 * @param login login of the user.
	 * @return user.
	 */
	public UserEntity findUsersByLogin(String login);
	
	/**
	 * Finds top-ranked users.
	 * 
	 * @param firstResult position of first user on the list.
	 * @param maxResults number of results to search.
	 * @return list of users.
	 */
	public List<UserEntity> findTopUsers(int firstResult, int maxResults);
	
	
	/**
	 * Finds users by given parameters.
	 * 
	 * @param login login of the user.
	 * @param name name of the user.
	 * @param surname surname of the user.
	 * @return list of users which match the given parameters.
	 */
	public List<UserEntity> findUsers(String login, String name, String surname);
}
