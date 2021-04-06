package messages;
import ticket.Ticket;


public interface CollectionMessages {

    String getTicketString(Ticket ticket);

    String getCollectionTypeMsg();

    String getCollectionInitDateMsg();

    String getCollectionSizeMsg();

    String getInputNameMsg();

    String getInputCoordinatesXMsg();

    String getInputCoordinatesYMsg();

    String getInputPriceMsg();

    String getInputTicketTypeMsg();

    String getInputVenueCapacityMsg();

    String getInputVenueNameMsg();

}

