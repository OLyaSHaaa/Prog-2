package input;

import exceptions.InvalidFieldException;
import exceptions.ScriptException;
import messages.Messenger;
import output.OutputManager;
import ticket.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScriptTicketReader implements TicketReader {
    private BufferedReader reader;
    private Messenger messenger;

    public ScriptTicketReader(BufferedReader reader, Messenger messenger) {
        this.reader = reader;
        this.messenger = messenger;
    }

    @Override
    public Ticket readTicket(){
        TicketBuilder ticketBuilder = new TicketBuilderImpl(messenger);
        ticketBuilder.setId();
        ticketBuilder.setVenueId();
        try {
            readFields(ticketBuilder);
        } catch(IOException | InvalidFieldException | NumberFormatException e){
            throw new ScriptException();
        }
        return ticketBuilder.getTicket();
    }

    @Override
    public Ticket readTicket(Long id, LocalDateTime creationDate, int venueId){
        TicketBuilder ticketBuilder = new TicketBuilderImpl(messenger);
        try {
            ticketBuilder.setId(id);
            ticketBuilder.setCreationDate(creationDate);
            ticketBuilder.setVenueId(venueId);
            readFields(ticketBuilder);
        } catch (IOException | InvalidFieldException | NumberFormatException e) {
            throw new ScriptException();
        }
        return ticketBuilder.getTicket();
    }

    private void readFields(TicketBuilder ticketBuilder) throws IOException, InvalidFieldException {
        ticketBuilder.setName(reader.readLine().trim());
        ticketBuilder.setCoordinatesX(Integer.parseInt(reader.readLine().trim()));
        ticketBuilder.setCoordinatesY(Double.parseDouble(reader.readLine().trim()));
        ticketBuilder.setPrice(Long.parseLong(reader.readLine().trim()));
        ticketBuilder.setTicketType(TicketType.valueOf(reader.readLine().trim().toUpperCase()));
        ticketBuilder.setVenueName(reader.readLine().trim());
        ticketBuilder.setVenueCapacity(Integer.parseInt(reader.readLine().trim()));

    }
}
