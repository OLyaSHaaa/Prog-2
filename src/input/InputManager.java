package input;

import ticket.Ticket;

import java.time.LocalDateTime;


public interface InputManager {

    boolean ready();

    String readCommand();

    Ticket readTicket();

    Ticket readTicket(Long id, LocalDateTime creationDate,int venueId);
}
