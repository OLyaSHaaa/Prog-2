package input;

import exceptions.InvalidFieldException;
import messages.Messenger;
import output.OutputManager;
import ticket.Ticket;
import ticket.TicketBuilder;
import ticket.TicketBuilderImpl;
import ticket.TicketType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleTicketReader implements TicketReader {
    private Scanner scanner;
    private Messenger messenger;
    private OutputManager outputManager;
    public ConsoleTicketReader(Scanner scanner, Messenger messenger, OutputManager outputManager) {
        this.scanner = scanner;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public Ticket readTicket(){
        TicketBuilder ticketBuilder = new TicketBuilderImpl(messenger);
        ticketBuilder.setId();
        readFields(ticketBuilder);
        return ticketBuilder.getTicket();
    }

    @Override
    public Ticket readTicket(Long id, LocalDateTime creationDate,int venueId) {
        TicketBuilder ticketBuilder = new TicketBuilderImpl(messenger);
        try {
            ticketBuilder.setId(id);
            ticketBuilder.setCreationDate(creationDate);
            ticketBuilder.setVenueId(venueId);
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
        }
        readFields(ticketBuilder);
        return ticketBuilder.getTicket();
    }

    private void readName(TicketBuilder ticketBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("name") + ": ");
        try{
            ticketBuilder.setName(scanner.nextLine().trim());
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readName(ticketBuilder);
        }
    }

    private void readCoordinatesX(TicketBuilder ticketBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("coordinatesX") + ": ");
        try{
            ticketBuilder.setCoordinatesX(Integer.parseInt(scanner.nextLine().trim()));
        } catch (NumberFormatException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noFloat") + "\n");
            readCoordinatesX(ticketBuilder);
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readCoordinatesX(ticketBuilder);
        }
    }

    private void readCoordinatesY(TicketBuilder ticketBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("coordinatesY") + ": ");
        try{
            ticketBuilder.setCoordinatesY(Double.parseDouble(scanner.nextLine().trim()));
        } catch (NumberFormatException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noInteger") + "\n");
            readCoordinatesY(ticketBuilder);
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readCoordinatesY(ticketBuilder);
        }
    }

    private void readPrice(TicketBuilder ticketBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("price") + ": ");
        try{
            ticketBuilder.setPrice(Long.parseLong(scanner.nextLine().trim()));
        } catch (NumberFormatException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noInteger") + "\n");
            readPrice(ticketBuilder);
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readPrice(ticketBuilder);
        }
    }

    private void readTicketType(TicketBuilder ticketBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("ticketType") + ": ");
        try{
            ticketBuilder.setTicketType(TicketType.valueOf(scanner.nextLine().trim().toUpperCase()));
        } catch (DateTimeParseException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noDate") + "\n");
            readTicketType(ticketBuilder);
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readTicketType(ticketBuilder);
        }
    }

    private void readVenueName(TicketBuilder ticketBuilder){
        outputManager.printMsg(messenger.getFieldInputMsg("venueName") + ": ");
        try{
            ticketBuilder.setVenueName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noEnum") + "\n");
            readVenueName(ticketBuilder);
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readVenueName(ticketBuilder);
        }
    }

    private void readVenueCapacity(TicketBuilder ticketBuilder) {
        outputManager.printMsg(messenger.getFieldInputMsg("venueCapacity") + ": ");
        try {
            ticketBuilder.setVenueCapacity(Integer.parseInt(scanner.nextLine().trim()));
        } catch (NumberFormatException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noFloat") + "\n");
            readVenueCapacity(ticketBuilder);
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            readVenueCapacity(ticketBuilder);
        }
    }

    private void readFields(TicketBuilder ticketBuilder){
        readName(ticketBuilder);
        readCoordinatesX(ticketBuilder);
        readCoordinatesY(ticketBuilder);
        readPrice(ticketBuilder);
        readTicketType(ticketBuilder);
        ticketBuilder.setVenueId();
        readVenueName(ticketBuilder);
        readVenueCapacity(ticketBuilder);
    }
}
