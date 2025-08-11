package org.jjr.domain.numberreceiver;

import org.jjr.domain.numberreceiver.dto.TicketDto;
import org.mapstruct.Mapper;

@Mapper
public interface TicketMapper {
    TicketDto toDto(Ticket ticket);
}
