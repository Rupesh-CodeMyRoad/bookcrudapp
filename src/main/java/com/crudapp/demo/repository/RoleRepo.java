package com.crudapp.demo.repository;

import com.crudapp.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {


//    @Query(value = "INSERT INTO users_roles(user_id, role_id) VALUES (:user_id, :role_id)", nativeQuery = true)
//    void setUserRole(@Param("user_id") Long user_id, @Param("role_id") Long role_id);


}
