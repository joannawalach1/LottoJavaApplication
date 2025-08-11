package org.jjr.domain.numberreceiver;

import lombok.Builder;

import java.util.Set;

@Builder
public record Ticket(Set<Integer> userNumbers, java.time.LocalDateTime ticketCreatedAt) {
}
