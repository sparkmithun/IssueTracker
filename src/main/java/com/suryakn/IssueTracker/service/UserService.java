package com.mithunm.IssueTracker.service;

import com.mithunm.IssueTracker.dto.UserProjection;
import com.mithunm.IssueTracker.entity.UserEntity;
import com.mithunm.IssueTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<List<UserProjection>> getAllUsers() {
        List<UserEntity> userList = userRepository.findAll();
        List<UserProjection> userProjectionList = new ArrayList<>();
        for (UserEntity userEntity : userList) {
            userProjectionList.add(new UserProjection(userEntity));
        }
        return ResponseEntity.ok(userProjectionList);
    }
}
