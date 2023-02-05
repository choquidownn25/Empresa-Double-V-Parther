package org.exemple.utils;

public enum StringResponse {
    ErrorSAVE("Tipo de usuario no permitido en la biblioteca",1),
    ErrorSREMOVE("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",2),
    ErrorNOHAYPRODUCTO("Producto no encontrado",3),
    ErrorSAVEBOOK("Tipo de usuario no permitido en la biblioteca",4),
    ErrorSREMOVEBOOK("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",5),
    ErrorNOHAYBOOK("Book no encontrado",6),
    ErrorSUPDATEBOOK("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",7),

    ErrorSAVETICKET("TICKET  no permitido",8),
    ErrorREMOVETICKET("No se puede eliminar TICKET",9),
    ErrorNOHAYTICKET("TICKET no encontrado",10),
    ErrorSUPDATETICKET("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",11),
    ACTIVOSTATUS("1", 12),
    ERRORFECHA("Error formato de fecha", 13),
    MOSTRARTICKET("Ticket Encontrado", 14),
    ErrorSUPDATE("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",401),
    OK("Registro agregado",200);



    private String name;
    private int code;


    private StringResponse (String name, int code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
