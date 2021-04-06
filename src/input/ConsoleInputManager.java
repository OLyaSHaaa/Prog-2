package input;

import messages.Messenger;
import output.OutputManager;
import ticket.Ticket;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleInputManager implements InputManager {
    private Scanner scanner;
    private CommandReader commandReader;
    private TicketReader ticketReader;

    public ConsoleInputManager(Messenger messenger, OutputManager outputManager) {
        scanner = new Scanner(System.in);
        commandReader = new ConsoleCommandReader(scanner);
        ticketReader = new ConsoleTicketReader(scanner, messenger, outputManager);
    }

    @Override
    public boolean ready() {
        return scanner.hasNext();
    }

    @Override
    public String readCommand() {
        return commandReader.readCommand();
    }

    @Override
    public Ticket readTicket() {
        return ticketReader.readTicket();
    }

    @Override
    public Ticket readTicket(Long id, LocalDateTime creationDate, int venueId) {
        return ticketReader.readTicket(id, creationDate,venueId);
    }
}