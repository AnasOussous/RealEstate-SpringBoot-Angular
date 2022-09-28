package com.RealEstate_BackEnd.repository;



import java.util.Optional;

import com.RealEstate_BackEnd.model.ERole;
import com.RealEstate_BackEnd.model.Role;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
