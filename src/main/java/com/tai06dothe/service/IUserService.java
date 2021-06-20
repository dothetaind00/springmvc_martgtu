package com.tai06dothe.service;

import com.tai06dothe.dto.UserDTO;

public interface IUserService {
	UserDTO save(UserDTO user);
	UserDTO findOneByUserName(String name);
}
