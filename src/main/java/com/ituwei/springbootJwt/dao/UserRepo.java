package com.ituwei.springbootJwt.dao;

import com.ituwei.springbootJwt.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserDetail,Integer> {
    UserDetail findByUsername(String username);
}
