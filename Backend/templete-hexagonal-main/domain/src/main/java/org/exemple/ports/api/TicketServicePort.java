package org.exemple.ports.api;

import org.exemple.data.TicketDTO;
import org.exemple.data.request.TicketDTORequest;
import org.exemple.data.response.TicketDTOResponse;

import java.util.List;

public interface TicketServicePort {
    TicketDTOResponse addTicket(TicketDTORequest ticketDTORequest);
    TicketDTOResponse updateTicket(TicketDTO ticket);
    void deleteTicket(Integer id);
    List<TicketDTO> getTicketList();
    TicketDTOResponse getTicketById(Integer id);
}
