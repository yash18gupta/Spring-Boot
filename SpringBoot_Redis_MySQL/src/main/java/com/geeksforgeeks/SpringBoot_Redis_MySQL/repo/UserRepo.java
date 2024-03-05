package com.geeksforgeeks.SpringBoot_Redis_MySQL.repo;

import com.geeksforgeeks.SpringBoot_Redis_MySQL.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

}
