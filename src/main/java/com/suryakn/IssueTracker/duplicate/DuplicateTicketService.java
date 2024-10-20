package com.mithunm.IssueTracker.duplicate;

import com.mithunm.IssueTracker.entity.VectorTable;
import com.mithunm.IssueTracker.repository.VectorTableRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DuplicateTicketService {

    private final VectorTableRepository ticketRepository;
    private final RestTemplate restTemplate;

    @Value("${duplicateservice.url}")
    private String duplicateServiceUrl;

    public PythonResponse processTicketEmbedding(DuplicateTicketRequest duplicateTicketRequest) {
        String text = duplicateTicketRequest.getTitle() + " " + duplicateTicketRequest.getDescription();

        List<VectorTable> ticketList = ticketRepository.findAllByProjectId(duplicateTicketRequest.getProjectId());
        List<TicketEmbeddingDTO> ticketEmbeddingDTOS = new ArrayList<>();
        for (VectorTable ticket : ticketList) {

            ticketEmbeddingDTOS.add(
                    TicketEmbeddingDTO.builder().ticketId(ticket.getTicketId()).vector(ticket.getVector()).build());
        }

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PythonDTO> request = new HttpEntity<>(PythonDTO.builder()
                .text(text)
                .ticketEmbeddingDTOS(ticketEmbeddingDTOS)
                .build(),
                headers);

        return restTemplate.postForObject(duplicateServiceUrl + "/process_ticket", request, PythonResponse.class);
    }
}
