package org.example.configuration;


import org.example.adapters.TicketJpaAdapter;
import org.exemple.ports.api.TicketServicePort;
import org.exemple.ports.spi.TicketPersistencePort;
import org.exemple.service.TicketServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConfig {

    @Bean
    public TicketPersistencePort ticketPersistencePort(){
        return new TicketJpaAdapter();
    }
    @Bean
    public TicketServicePort ticketServicePort(){
        return new TicketServiceImpl(ticketPersistencePort());
    }

}
