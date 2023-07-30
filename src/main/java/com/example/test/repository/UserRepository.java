package com.example.test.repository;

import com.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from new_schema.user where user.lastname like %:keyword% or user.name like %:keyword% or user.email like %:keyword% or user.role like %:keyword%", nativeQuery = true)
    List<User> findByKeyword (@Param("keyword")String keyword);
}
