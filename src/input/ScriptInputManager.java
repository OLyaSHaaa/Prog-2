package input;

import messages.Messenger;
import output.OutputManager;
import ticket.Ticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScriptInputManager implements InputManager{
    private BufferedReader reader;
    private CommandReader commandReader;
    private TicketReader ticketReader;

    public ScriptInputManager(BufferedReader reader, Messenger messenger){
        this.reader = reader;
        commandReader = new ScriptCommandReader(reader, messenger);
        ticketReader = new ScriptTicketReader(reader, messenger);
    }

    @Override
    public boolean ready() {
        try {
            return reader.ready();
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readCommand(){
        return commandReader.readCommand();
    }

    @Override
    public Ticket readTicket(){
        return ticketReader.readTicket();
    }

    @Override
    public Ticket readTicket(Long id, LocalDateTime creationDate, int venueId){
        return ticketReader.readTicket(id, creationDate,venueId);
    }
}
