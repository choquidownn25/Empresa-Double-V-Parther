package org.example.controller;

import org.exemple.data.TicketDTO;
import org.exemple.data.request.TicketDTORequest;
import org.exemple.data.response.TicketDTOResponse;
import org.exemple.ports.api.TicketServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketServicePort ticketServicePort;
    @Autowired
    public TicketController(TicketServicePort ticketServicePort) {
        this.ticketServicePort = ticketServicePort;
    }

    @PostMapping("/add")
    public ResponseEntity<TicketDTOResponse> addTicket(@RequestBody TicketDTORequest ticketDTO){
        TicketDTOResponse ticketDTOResponse = new TicketDTOResponse();
        ticketDTOResponse = ticketServicePort.addTicket(ticketDTO);
        if(ticketDTOResponse != null) {
            return new ResponseEntity<TicketDTOResponse>(ticketDTOResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<TicketDTOResponse>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<TicketDTOResponse> updateTicket(@RequestBody TicketDTO ticketDTO){
        TicketDTOResponse ticketDTOResponse = new TicketDTOResponse();
        ticketDTOResponse = ticketServicePort.updateTicket(ticketDTO);
        if(ticketDTOResponse != null) {
            return new ResponseEntity<TicketDTOResponse>(ticketDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<TicketDTOResponse>(ticketDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<TicketDTO>> getTicket( ){
        List<TicketDTO> listTicketDTOResponse = new ArrayList<>();
        listTicketDTOResponse = ticketServicePort.getTicketList();
        if(listTicketDTOResponse != null) {
            return new ResponseEntity<List<TicketDTO>>(listTicketDTOResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<TicketDTO>>(listTicketDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TicketDTOResponse> getByIdTicket(@PathVariable Integer id){
        TicketDTOResponse ticketDTOResponse = new TicketDTOResponse();
        ticketDTOResponse = ticketServicePort.getTicketById(id);
        if(ticketDTOResponse != null) {
            return new ResponseEntity<TicketDTOResponse>(ticketDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<TicketDTOResponse>(ticketDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Integer id){
        ticketServicePort.deleteTicket(id);
    }
}
