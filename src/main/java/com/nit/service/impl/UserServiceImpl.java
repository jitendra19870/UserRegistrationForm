package com.nit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nit.model.User;
import com.nit.repository.UserRepository;
import com.nit.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Transactional
	public void deleteUserById(Integer userId) {
		userRepository.deleteById(userId);

	}

	@Transactional
	public Optional<User> getUserById(Integer userId) {
		/*
		 * if(id==1) { return new User("1","Ashok","ashok","Male","Hyd"); }else {
		 * //throw custom exception }
		 */

		return userRepository.findById(userId);
	}

	@Transactional
	public void updateUser(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> findByUserName(String userName) {

		return userRepository.findByUserName(userName);
	}

	@Override
	public List<User> findByUserCity(String city) {

		return userRepository.findByUserCity(city);
	}

	@Override
	public List<User> findByRoleSorted(String userRoles) {
		List<User> userList = userRepository.findByRoleSorted(userRoles);

		return userList;
	}

	@Override
	public List<User> findByCitySorted(String userCity) {

		return userRepository.findByCitySorted(userCity);
	}

	@Override
	public List<User> findByUserGender(String userGen) {
		List<User> userList = userRepository.findByUserGender(userGen);

		return userList;
	}

	@Override
	public List<String> findAllCity() {
		
		return userRepository.findAllCity();
	}

	

	@Override
	public Page<User> findPageOfRecords(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	} 

}
