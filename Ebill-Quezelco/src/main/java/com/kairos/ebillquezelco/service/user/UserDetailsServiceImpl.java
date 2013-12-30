package com.kairos.ebillquezelco.service.user;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.domain.user.UserAccount;
import com.kairos.ebillquezelco.domain.user.UserRoles;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Getting UserAccount Entity with username: " + username);
		UserAccount userAccount = userAccountService.getByUsername(username);
		if (userAccount==null) {
			throw new UsernameNotFoundException("User with username: " + username + " cannot be found!");
		}
		return createUser(userAccount);
	}
	
	private User createUser(UserAccount userAccount) {
		logger.info("Creating Spring Security User from UserAccount Entity: " + userAccount.toString());
		return new User(userAccount.getUsername(), userAccount.getPassword(), createAuthorities(userAccount));
	}
	
	private Collection<GrantedAuthority> createAuthorities(UserAccount userAccount) {
		logger.info("Adding GrantedAuthorities to Spring Security User...");
		Collection<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
		for (UserRoles userRole : userRolesService.getByUserAccount(userAccount)) {
			String strRole = userRole.getRole().getRole();
			logger.info("Adding Role:" + strRole);
			gaList.add(new SimpleGrantedAuthority(strRole));
		}
		return gaList;
	}
	
	private Authentication authenticate(UserAccount userAccount) {
		return new UsernamePasswordAuthenticationToken(createUser(userAccount), null, createAuthorities(userAccount));		
	}
	
	public void signin(UserAccount UserAccount) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(UserAccount));
	}

}
