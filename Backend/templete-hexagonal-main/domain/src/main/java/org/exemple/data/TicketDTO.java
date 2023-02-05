package org.exemple.data;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private Integer id;


    private String usuario;

    private LocalDate fechaCreacion;

    private LocalDate fechaActualizacion;

    private Integer estatus;

   

}