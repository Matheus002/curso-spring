package com.matheus.cursoudemy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matheus.cursoudemy.domain.Client;
import com.matheus.cursoudemy.repositories.ClientRepository;
import com.matheus.cursoudemy.security.UserSS;

@Service
public class UserDettailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClientRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client cli = repo.findByEmail(email);
		
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(cli.getId(), cli.getEmail(), cli.getPassword(), cli.getProfiles());
	}

}
