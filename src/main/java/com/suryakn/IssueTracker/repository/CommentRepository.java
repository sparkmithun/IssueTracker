package com.mithunm.IssueTracker.repository;

import com.mithunm.IssueTracker.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTicket_Id(Long ticket_id);

    void deleteAllByTicket_Id(Long ticket_id);
}
