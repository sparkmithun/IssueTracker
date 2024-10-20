package com.mithunm.IssueTracker.controller;

import com.mithunm.IssueTracker.dto.CommentDto;
import com.mithunm.IssueTracker.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tickets/{ticketId}/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> all(@PathVariable Long ticketId) {
        return commentService.getAllComments(ticketId);
    }

    @PostMapping
    public ResponseEntity<CommentDto> saveComment(@PathVariable Long ticketId, @RequestBody CommentDto body) {
        return commentService.addComment(ticketId, body);
    }

//    @DeleteMapping
//    TODO: delete individual comment
//    public void deleteComment(@PathVariable Long ticketId) {
//        commentRepository.
//    }
}
