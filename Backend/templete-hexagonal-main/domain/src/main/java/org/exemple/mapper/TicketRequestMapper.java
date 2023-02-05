package org.exemple.mapper;

import org.exemple.data.BookDTO;
import org.exemple.data.TicketDTO;
import org.exemple.data.request.TicketDTORequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketRequestMapper {
    TicketRequestMapper INSTANCE = Mappers.getMapper(TicketRequestMapper.class);
    TicketDTORequest ticketDTORequestTOTicketDTO(TicketDTO ticketDTO);
    TicketDTO ticketDTOTOticketDTORequest(TicketDTORequest ticketDTORequest);
}
