package com.nit.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nit.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	//public Integer saveUser(User user);
	public List<User> findByUserName(String userName);
	public List<User> findByUserCity(String city);
	@Query("select userCity from User")
	public List<String> findAllCity() ;
	
	@Query(" from User where userRoles=?1 order by userName")
	public List<User> findByRoleSorted(String userRoles);
	@Query("from User where userCity=?1 order by userName")
	public List<User> findByCitySorted(String userCity);
	@Query("from User u where u.userGen=?1")
	public List<User> findByUserGender(String userGen);
	
	
	//public Page<User> findPageOfRecords(Pageable pageable);
	
	
	

	
}
