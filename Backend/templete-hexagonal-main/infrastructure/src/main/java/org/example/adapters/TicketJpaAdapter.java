package org.example.adapters;

import org.example.entity.Ticket;
import org.example.mappers.TicketMapper;
import org.example.repository.TicketRepository;
import org.exemple.data.TicketDTO;
import org.exemple.ports.spi.TicketPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketJpaAdapter implements TicketPersistencePort {
    @Autowired
    private TicketRepository ticketRepository;



    @Override
    public TicketDTO addTicket(TicketDTO ticketDTO) {
        // convert DTO to Entity
        Ticket postTicket = TicketMapper.INSTANCE.ticketToTicket(ticketDTO);
        Ticket ticket = ticketRepository.save(postTicket);
        TicketDTO ticketDTOs = TicketMapper.INSTANCE.ticketDTOToTicket(ticket);
        return ticketDTOs;
    }

    @Override
    public TicketDTO updateupdate(TicketDTO ticketDTO) {
        // convert DTO to Entity
        Ticket postTicket = TicketMapper.INSTANCE.ticketToTicket(ticketDTO);
        Ticket ticket = ticketRepository.save(postTicket);
        TicketDTO ticketDTOs = TicketMapper.INSTANCE.ticketDTOToTicket(ticket);
        return ticketDTOs;
    }

    @Override
    public void deleteTicket(Integer id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<TicketDTO> getTicketList() {
        List<Ticket> listTickets = ticketRepository.findAll();
        //Mapeo la lista
        return TicketMapper.INSTANCE.ticketsListDTOToTicket(listTickets);
    }

    @Override
    public TicketDTO getTicketById(Integer id) {
        //Encuentra un Registro
        Optional<Ticket> ticketId = ticketRepository.findById(id);
        if (ticketId.isPresent()) {
            return TicketMapper.INSTANCE.ticketDTOToTicket(ticketId.get());
        }else{
            throw new IllegalStateException("This is example of IllegalStateException");
        }
    }

}
