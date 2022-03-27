package com.botaniac.accountsservice.repository;

import com.botaniac.accountsservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, String> {
}
