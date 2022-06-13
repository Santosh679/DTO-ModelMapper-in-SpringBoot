package com.dtotaskwithspringboot.dtoproject.repository;

import com.dtotaskwithspringboot.dtoproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
