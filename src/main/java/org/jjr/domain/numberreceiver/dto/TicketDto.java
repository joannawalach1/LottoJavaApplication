package org.jjr.domain.numberreceiver.dto;

import lombok.Builder;

import java.util.Set;
@Builder
public record TicketDto(Set<Integer> userNumbers) {
}
