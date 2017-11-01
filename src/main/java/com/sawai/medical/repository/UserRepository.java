package com.sawai.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sawai.medical.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User getByEmailId(@Param("emailId") String emailId);
}
