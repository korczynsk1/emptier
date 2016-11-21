package it.korczynski.emptier.dataaccess.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import it.korczynski.emptier.dataaccess.dao.UserDao;
import it.korczynski.emptier.dataaccess.entities.UserEntity;

/**
 * Implementation of {@link UserDao}.
 * 
 */
@Repository
public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {

	/** {@inheritDoc} */
	@Override
	public UserEntity findUsersByLogin(String login) {
		Query query = entityManager.createQuery("SELECT u FROM UserEntity u "
				+ "WHERE u.login = :login");
		query.setParameter("login", login);
		try {
			return (UserEntity) query.getSingleResult();
		}
		catch (NoResultException ex) {
			return null;
		}
	}

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findTopUsers(int firstResult, int maxResults) {
		Query query = entityManager.createQuery("SELECT u FROM UserEntity u "
				+ "ORDER BY u.level desc, u.points desc, u.id asc")
				.setFirstResult(firstResult)
				.setMaxResults(maxResults);
		return query.getResultList();
	}

	/** {@inheritDoc} */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> findUsers(String login, String name, String surname) {
		Query query = entityManager.createQuery("SELECT u FROM UserEntity u "
				+ "WHERE u.login = :login OR u.name = :name OR u.surname = :surname");
		query.setParameter("login", login);
		query.setParameter("name", name);
		query.setParameter("surname", surname);
		return query.getResultList();
	}

}
