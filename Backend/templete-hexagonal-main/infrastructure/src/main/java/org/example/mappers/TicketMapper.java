package org.example.mappers;

import org.example.entity.Ticket;
import org.exemple.data.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);
    TicketDTO ticketDTOToTicket (Ticket ticket);
    Ticket ticketToTicket (TicketDTO ticketDTO);
    List<Ticket> ticketsListToTicketDTO (List<TicketDTO> ticketsdtosDTO);
    List<TicketDTO> ticketsListDTOToTicket (List<Ticket> tickets);
}
