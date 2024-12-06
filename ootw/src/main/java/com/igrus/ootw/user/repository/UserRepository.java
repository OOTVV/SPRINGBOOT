package com.igrus.ootw.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igrus.ootw.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
