package org.jjr.domain.numberreceiver;

import lombok.RequiredArgsConstructor;
import org.jjr.domain.numberreceiver.dto.TicketDto;

import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
public class NumberReceiverFacade {
    private final UserNumbersValidator userNumbersValidator;

    public TicketDto getNumbersFromUser(Set<Integer> userNumbers) {
        userNumbersValidator.validateUserNumbers(userNumbers);
        LocalDateTime ticketCreatedDate = LocalDateTime.now();
        Ticket newTicket = new Ticket(userNumbers, ticketCreatedDate);
        TicketDto newTicketDto = NumberReceiverMapper.toDto(newTicket);
        return newTicketDto;
    }
}
