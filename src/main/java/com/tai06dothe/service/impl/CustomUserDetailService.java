package com.tai06dothe.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tai06dothe.constant.SystemConstant;
import com.tai06dothe.dto.UserPrincipal;
import com.tai06dothe.entity.RoleEntity;
import com.tai06dothe.entity.UserEntity;
import com.tai06dothe.repository.UserRepository;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		
		if (userEntity != null) {
			Set<GrantedAuthority> authorities = new HashSet<>();

			for (RoleEntity role : userEntity.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getCode()));
			}
			
			UserPrincipal user = new UserPrincipal(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
			user.setFirstName(userEntity.getFirstName());
			user.setLastName(userEntity.getLastName());
			user.setSex(userEntity.getSex());
			user.setAddress(userEntity.getAddress());
			user.setEmail(userEntity.getEmail());
			user.setNumberPhone(userEntity.getNumberPhone());
			user.setStatus(userEntity.getStatus());
			
			return user;
		}
		
		throw new UsernameNotFoundException(username + " not found");
	}

}
