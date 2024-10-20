package com.suryakn.IssueTracker.dto;

import com.suryakn.IssueTracker.entity.Priority;
import com.suryakn.IssueTracker.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private List<CommentDto> comments;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private CreatedByDto created;
    private CreatedByDto assigned;
    private ProjectDto project;

    private List<SimilarTickets> similarTickets;

}
