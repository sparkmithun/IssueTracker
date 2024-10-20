package com.mithunm.IssueTracker.repository;

import com.mithunm.IssueTracker.dto.UserProjection;
import com.mithunm.IssueTracker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);

    List<UserProjection> findAllBy();
}
