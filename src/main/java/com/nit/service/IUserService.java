package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.nit.model.User;

public interface IUserService {
	public User saveUser(User user);
	public List<User> getAllUsers();
	public void deleteUserById(Integer userId);
	public Optional<User> getUserById(Integer userId);
	public void updateUser(User user);
	
	public Page<User> findPageOfRecords(Pageable pageable);
	
	public List<User> findByUserName(String userName);
	public List<User> findByUserCity(String city);
	@Query("from usertab where urole=?1 order by uname")
	public List<User> findByRoleSorted(String userRoles);
	@Query("from User where userCity=?1 oreder by userName")
	public List<User> findByCitySorted(String userCity);
	@Query("from User u where u.userGen=?1")
	public List<User> findByUserGender(String userGen);
	@Query("select userCity from User")
	public List<String> findAllCity() ;
	

}
