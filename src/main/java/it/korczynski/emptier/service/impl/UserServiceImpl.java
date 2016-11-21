package it.korczynski.emptier.service.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.korczynski.emptier.dataaccess.dao.UserDao;
import it.korczynski.emptier.dataaccess.entities.UserEntity;
import it.korczynski.emptier.dataaccess.enums.Level;
import it.korczynski.emptier.service.UserService;
import it.korczynski.emptier.service.mapper.UserProfileMapper;
import it.korczynski.emptier.service.to.UserProfileTO;

/**
 * Implementation of {@link UserService}.
 * 
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/** {@inheritDoc} */
	@Override
	public UserProfileTO updateUser(UserProfileTO userTo) {
		UserEntity userEntity = userDao.get(userTo.getId());
		userEntity = UserProfileMapper.update(userEntity, userTo);
		userEntity = userDao.update(userEntity);
		return UserProfileMapper.map(userEntity);
	}

	/** {@inheritDoc} */
	@Override
	public UserProfileTO createUser(UserProfileTO userTo) throws EntityExistsException {
		UserEntity user = userDao.findUsersByLogin(userTo.getLogin());
        if (user != null){
            throw new EntityExistsException();
        }
		
		UserEntity userEntity = UserProfileMapper.map(userTo);
		userEntity.setLevel(Level.NEWBIE);
		userEntity = userDao.create(userEntity);
		return UserProfileMapper.map(userEntity);
	}

	/** {@inheritDoc} */
	@Override
	public void deleteUser(Long id) {
		userDao.delete(id);
	}

	/** {@inheritDoc} */
	@Override
	public UserProfileTO findUserProfileByLogin(String login) throws EntityNotFoundException {
		UserEntity userEntity = userDao.findUsersByLogin(login);
		if (userEntity == null) {
			throw new EntityNotFoundException();
		}
		return UserProfileMapper.map(userEntity);
	}

	/** {@inheritDoc} */
	@Override
	public List<UserProfileTO> findUsers(String login, String name, String surname) {
		List<UserEntity> userEntities = userDao.findUsers(login, name, surname);
		return UserProfileMapper.map2TOs(userEntities);
	}

}
