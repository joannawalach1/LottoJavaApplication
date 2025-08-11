package org.jjr.domain.numberreceiver;

import org.jjr.domain.numberreceiver.dto.TicketDto;
import org.mapstruct.Mapper;

@Mapper
public interface TicketMapper {
    static TicketDto toDto(Ticket ticket);
}
