package com.example.demoSpringDataJPAH2Rest.repository;

import com.example.demoSpringDataJPAH2Rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
