package input;

import ticket.Ticket;

import java.time.LocalDateTime;


public interface TicketReader {

    Ticket readTicket();

    Ticket readTicket(Long id, LocalDateTime creationDate, int venueId);

}
