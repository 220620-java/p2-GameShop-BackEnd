package com.revature.gameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gameshop.models.Role;
import com.revature.gameshop.models.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
