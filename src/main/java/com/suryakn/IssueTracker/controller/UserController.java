package com.mithunm.IssueTracker.controller;

import com.mithunm.IssueTracker.dto.UserProjection;
import com.mithunm.IssueTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<UserProjection>> getAllUsers() {
        return userService.getAllUsers();
    }
}
