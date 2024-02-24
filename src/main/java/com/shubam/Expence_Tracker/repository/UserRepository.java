package com.shubam.Expence_Tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shubam.Expence_Tracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(value="select u from User u where u.emailId=?1 and u.password=?2")
	public User userLogin(String emailId, String password);
	
	@Query(value="select case when count(u)>0 then true else false end from User u where u.emailId=?1")
	public boolean findByEmailId(String emailId);
	
	@Query(value="select case when count(u)>0 then true else false end from User u where u.phoneNumber=?1")
	public boolean findByPhoneNumber(String poneNumber);

}
