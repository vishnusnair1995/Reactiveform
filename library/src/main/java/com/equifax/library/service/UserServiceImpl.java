package com.equifax.library.service;
//
//import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equifax.library.dto.UserDTO;
import com.equifax.library.model.User;
import com.equifax.library.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public String addUser(UserDTO userDTO) {
		User user = createUserFromUserDTO(userDTO);
		userRepo.save(user);
		return "User Added Successfully";
	}
	

	public String deleteUser(int userId) {
		User user=userRepo.findById(userId).orElse(null);
		if(null!=user) {
		String name=user.getUserName();
		userRepo.delete(user);
		return name +" deleted";
		}else {
			return "User not found";
		}
	}
	

	public boolean authenticateUser(int userId) {
		User user=userRepo.findById(userId).orElse(null);
		if(null!=user && user.getUserRole().equalsIgnoreCase("Admin")) { 
			return true;
		}else {
			return false;
		}
    }
	
	private User createUserFromUserDTO(UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setUserRole(userDTO.getUserRole());
		return user;
	}
	
	public String validateUser(UserDTO userDTO) {
		if(userDTO.getUserName().isEmpty()) {
			return "User name cannot be empty";
		}else if(userDTO.getUserRole().isEmpty())
		{
			return "User role cannot be empty";
		}
		else 
			return "Success";		
	}
	
	
}