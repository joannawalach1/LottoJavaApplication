package org.jjr.domain.numberreceiver;

import org.jjr.domain.numberreceiver.dto.TicketDto;

import java.time.LocalDateTime;
import java.util.Set;

public class NumberReceiverFacade {
    private UserNumberValidator userNumberValidator;
    private TicketMapper ticketMapper;

    public TicketDto getNumbersFromUser(Set<Integer> userNumbers) {
        userNumberValidator.validateNumbers(userNumbers);
        LocalDateTime ticketCreatedAt = LocalDateTime.now();
        Ticket newTicket = new Ticket(userNumbers, ticketCreatedAt);
        TicketDto ticketDto = ticketMapper.toDto(newTicket);
        return ticketDto;
    }
}