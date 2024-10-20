package com.mithunm.IssueTracker.duplicate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PythonDTO {
    private String text;
    private List<TicketEmbeddingDTO> ticketEmbeddingDTOS;
}
