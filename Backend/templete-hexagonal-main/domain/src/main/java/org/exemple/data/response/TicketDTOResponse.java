package org.exemple.data.response;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.exemple.data.TicketDTO;

import java.util.List;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTOResponse {
    private List<TicketDTO> listTicketDTO;
    private Message message;
}
