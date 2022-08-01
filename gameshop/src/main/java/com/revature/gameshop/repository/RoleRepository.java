package com.revature.gameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gameshop.models.Role;
import com.revature.gameshop.models.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
