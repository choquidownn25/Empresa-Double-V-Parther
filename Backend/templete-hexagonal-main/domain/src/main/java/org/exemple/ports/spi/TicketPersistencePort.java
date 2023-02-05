package org.exemple.ports.spi;

import org.exemple.data.TicketDTO;

import java.util.List;

public interface TicketPersistencePort {
    TicketDTO addTicket(TicketDTO ticketDTO);
    TicketDTO updateupdate(TicketDTO ticketDTO);
    void deleteTicket(Integer id);
    List<TicketDTO> getTicketList();
    TicketDTO getTicketById(Integer id);
}
