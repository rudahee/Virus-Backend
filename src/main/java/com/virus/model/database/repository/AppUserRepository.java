package com.virus.model.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virus.model.database.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByUsername(String username);
	
	Optional<AppUser> findByUsernameAndPassword(String username, String password);

	boolean existsUserByEmail(String email);
	
	boolean existsUserByUsername(String username);
	
}
