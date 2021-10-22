package com.kollector.app.repository;

import com.kollector.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository for the 2 roles

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
