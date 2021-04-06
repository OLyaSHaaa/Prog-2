package messages;

import exceptions.NoSuchCommandException;
import ticket.Ticket;

public interface Messenger {

    String getExceptionMsg(String msgName);

    String getCommandDescription(String commandName) throws NoSuchCommandException;

    String getCollectionTypeMsg();

    String getCollectionInitDateMsg();

    String getCollectionSizeMsg();

    String getTicketString(Ticket ticket);

    String getFieldInputMsg(String fieldName);

    String getStartMsg();

    String getFinishMsg();
}
