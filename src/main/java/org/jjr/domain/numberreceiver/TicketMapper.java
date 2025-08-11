package org.jjr.domain.numberreceiver;

import org.jjr.domain.numberreceiver.dto.TicketDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface TicketMapper {
    TicketDto toDto(Ticket ticket);
}
