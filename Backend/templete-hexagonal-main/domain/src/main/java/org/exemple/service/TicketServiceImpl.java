package org.exemple.service;

import org.exemple.data.TicketDTO;
import org.exemple.data.request.TicketDTORequest;
import org.exemple.data.response.Message;
import org.exemple.data.response.TicketDTOResponse;
import org.exemple.mapper.TicketRequestMapper;
import org.exemple.ports.api.TicketServicePort;
import org.exemple.ports.spi.TicketPersistencePort;
import org.exemple.utils.StringResponse;
import org.exemple.utils.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketServicePort {

    private TicketPersistencePort ticketPersistencePort;
    @Autowired
    public TicketServiceImpl(TicketPersistencePort ticketPersistencePort) {
        this.ticketPersistencePort = ticketPersistencePort;
    }

    @Override
    public TicketDTOResponse addTicket(TicketDTORequest ticketDTORequest) {
        TicketDTOResponse response = new TicketDTOResponse();
        TicketDTO ticketDTO =null;
        Message message = new Message();
        List<TicketDTO> tickets =new ArrayList<>();
        if (ticketDTORequest == null || ticketDTORequest.getUsuario() == null || ticketDTORequest.getFechaActualizacion()==null) {
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);
        }else{
            TicketDTO postTicket = TicketRequestMapper.INSTANCE.ticketDTOTOticketDTORequest(ticketDTORequest);

            postTicket.setFechaCreacion(LocalDate.now());
            postTicket.setEstatus(Integer.valueOf(StringResponse.ACTIVOSTATUS.getName()));


            if (Validaciones.isValid_DateTime(String.valueOf(postTicket.getFechaActualizacion()))){
                message.setEcho (StringResponse.ERRORFECHA.getName());
                message.setCode( StringResponse.ERRORFECHA.getCode());
                response.setMessage( message);
            }else{

                ticketDTO = ticketPersistencePort.addTicket(postTicket);
                if (ticketDTO==null) {
                    message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                    message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                    response.setMessage( message);
                }else{
                    tickets.add(ticketDTO);
                    message.setEcho (StringResponse.OK.getName());
                    message.setCode( StringResponse.OK.getCode());
                    response.setMessage( message);
                    response.setListTicketDTO(tickets);
                }
            }
        }


        return response;
    }

    @Override
    public TicketDTOResponse updateTicket(TicketDTO ticket) {
        TicketDTOResponse response = new TicketDTOResponse();
        TicketDTO ticketDTO =null;
        List<TicketDTO> tickets =new ArrayList<>();
        Message message = new Message();
        ticketDTO = ticketPersistencePort.updateupdate(ticket);
        if (ticketDTO==null) {
            message.setEcho (StringResponse.ErrorSUPDATETICKET.getName());
            message.setCode( StringResponse.ErrorSUPDATETICKET.getCode());
            response.setMessage( message);
        }else{
            tickets.add(ticketDTO);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListTicketDTO(tickets);
        }
        return response;
    }

    @Override
    public void deleteTicket(Integer id) {
        try {
            ticketPersistencePort.deleteTicket(id);
        }catch (Exception e) {
            throw new RuntimeException("Error" + e.getMessage());
        }
    }

    @Override
    public List<TicketDTO> getTicketList() {
        return ticketPersistencePort.getTicketList();
    }

    @Override
    public TicketDTOResponse getTicketById(Integer id) {
        TicketDTOResponse response = new TicketDTOResponse();
        TicketDTO ticketDTO =null;
        List<TicketDTO> tickets =new ArrayList<>();
        Message message = new Message();
        ticketDTO = ticketPersistencePort.getTicketById(id);
        if (ticketDTO==null) {
            message.setEcho (StringResponse.ErrorNOHAYTICKET.getName());
            message.setCode( StringResponse.ErrorNOHAYTICKET.getCode());
            response.setMessage( message);
        }else{
            tickets.add(ticketDTO);
            message.setEcho (StringResponse.MOSTRARTICKET.getName());
            message.setCode( StringResponse.MOSTRARTICKET.getCode());
            response.setMessage( message);
            response.setListTicketDTO(tickets);
        }
        return response;
    }
}
