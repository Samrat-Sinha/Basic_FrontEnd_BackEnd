package com.UserBackEnd.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserBackEnd.Model.User;

@Repository
public interface UserRepositary extends JpaRepository<User, Long>{

	Optional<User> findByPhoneNumber(String phoneNumber);
	
}
