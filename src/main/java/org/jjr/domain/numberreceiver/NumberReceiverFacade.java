package org.jjr.domain.numberreceiver;


import org.jjr.domain.numberreceiver.dto.TicketDto;
import java.time.Clock;

import java.time.LocalDateTime;
import java.util.Set;

public class NumberReceiverFacade {
    private final NumberReceiverRepository numberReceiverRepository;
    private final UserNumberValidator userNumberValidator;
    private final TicketMapper ticketMapper;
    private final Clock clock;
    private final DrawDateGenerator drawDateGenerator;
    private final HashGenerable hashGenerable;

    public NumberReceiverFacade(NumberReceiverRepository numberReceiverRepository, UserNumberValidator userNumberValidator, TicketMapper ticketMapper, Clock clock, DrawDateGenerator drawDateGenerator, HashGenerable hashGenerable) {
        this.numberReceiverRepository = numberReceiverRepository;
        this.userNumberValidator = userNumberValidator;
        this.ticketMapper = ticketMapper;
        this.clock = clock;
        this.drawDateGenerator = drawDateGenerator;
        this.hashGenerable = hashGenerable;
    }


    public Ticket getNumbersFromUser(Set<Integer> userNumbers) {
        userNumberValidator.validateNumbers(userNumbers);
        String id = hashGenerable.generateHash();
        LocalDateTime ticketCreatedAt = LocalDateTime.now();
        Ticket newTicket = new Ticket(id, userNumbers, ticketCreatedAt);
        numberReceiverRepository.save(newTicket);
        TicketDto ticketDto = ticketMapper.toDto(newTicket);
        return newTicket;
    }
}

