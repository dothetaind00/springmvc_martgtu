package com.tai06dothe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tai06dothe.dto.RoleDTO;
import com.tai06dothe.dto.UserDTO;
import com.tai06dothe.entity.RoleEntity;
import com.tai06dothe.entity.UserEntity;
import com.tai06dothe.repository.RoleRepository;
import com.tai06dothe.repository.UserRepository;
import com.tai06dothe.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	@Override
	public UserDTO save(UserDTO user) {
		
		if (user.getId() != null) {
			
			UserEntity userEntity = userRepository.findOne(user.getId());
			userEntity = modelMapper.map(user,UserEntity.class);
			
			userEntity.setPassword(passwordEncoder.encode(userEntity.getPasswordText()));
			userEntity.setRoles(user.getRoles()
					.stream().map(r -> {
						RoleEntity rr = roleRepository.findByCode(r.getCode());
//						rr.getUsers().add(userEntity);
						return rr;
					}).collect(Collectors.toList()));
			
			return modelMapper.map(userRepository.save(userEntity),UserDTO.class);
		}else {
			user.setStatus(true);
			List<RoleDTO> roles = new ArrayList<>();
			RoleDTO role = new RoleDTO();
			role.setCode("USER");
			roles.add(role);
			user.setRoles(roles);
			
			UserEntity userEntity = modelMapper.map(user,UserEntity.class);
			userEntity.setPassword(passwordEncoder.encode(userEntity.getPasswordText()));
			userEntity.setRoles(user.getRoles()
					.stream().map(r -> {
						RoleEntity rr = roleRepository.findByCode(r.getCode());
						rr.getUsers().add(userEntity);
						return rr;
					}).collect(Collectors.toList()));
			return modelMapper.map(userRepository.save(userEntity),UserDTO.class);
		}
		
	}

	@Override
	public UserDTO findOneByUserName(String name) {
		
		return modelMapper.map(userRepository.findOneByUserName(name),UserDTO.class);
	}
	
}
