package it.korczynski.emptier;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import it.korczynski.emptier.service.UserService;
import it.korczynski.emptier.service.to.UserProfileTO;

/**
 * Implementation of {@link UserDetailsImpl}.
 * 
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService service;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		try {
			UserProfileTO user = service.findUserProfileByLogin(login);
			return new UserDetailsImpl(user);
		} catch (EntityNotFoundException e) {
			throw new UsernameNotFoundException("no user found with login " + login);
		}
		
	}

}
