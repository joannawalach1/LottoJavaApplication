package org.jjr.domain.numberreceiver;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;
@Builder
public record Ticket(Set<Integer> userNumbers, LocalDateTime ticketCreatedAt) {
}
