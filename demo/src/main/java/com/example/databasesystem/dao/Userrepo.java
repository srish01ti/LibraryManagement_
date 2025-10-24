package com.example.databasesystem.dao;


import com.example.databasesystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
