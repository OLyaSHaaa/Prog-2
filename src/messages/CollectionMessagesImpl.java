package messages;

import ticket.Ticket;
/**
 * Реализация интерфейса CollectionMessages с английской локализацией
 */
public class CollectionMessagesImpl implements CollectionMessages{
    private final String collectionTypeMsg;
    private final String collectionInitDateMsg;
    private final String collectionSizeMsg;
    private final String inputNameMsg;
    private final String inputCoordinatesXMsg;
    private final String inputCoordinatesYMsg;
    private final String inputPriceMsg;
    private final String inputTicketTypeMsg;
    private final String inputVenueNameMsg;
    private final String inputVenueCapacityMsg;


    public CollectionMessagesImpl() {
        collectionTypeMsg = "Collection type";
        collectionInitDateMsg = "Initialization date";
        collectionSizeMsg = "Number of elements";
        inputNameMsg = "Name";
        inputCoordinatesXMsg = "coordinates.x";
        inputCoordinatesYMsg = "coordinates.y";
        inputPriceMsg = "price";
        inputTicketTypeMsg = "ticketType ( VIP, USUAL, BUDGETARY, CHEAP )";
        inputVenueNameMsg = "venue.name";
        inputVenueCapacityMsg = "venue.capacity";
    }

    @Override
    public String getTicketString(Ticket ticket){
        return String.format("id=%d; name=%s; coordinates=(%d, %.2f); creationDate=%s; ticketType=%s; price=%d;  " +
                        "venueId=%d; venueName=%s; venueCapacity=%d", ticket.getId(), ticket.getName(),
                ticket.getCoordinates().getX(), ticket.getCoordinates().getY(), ticket.getCreationDate().toLocalDate(),
                ticket.getTicketType(), ticket.getPrice(),
                ticket.getVenue().getId(), ticket.getVenue().getName(), ticket.getVenue().getCapacity());
    }

    @Override
    public String getCollectionTypeMsg() {
        return collectionTypeMsg;
    }

    @Override
    public String getCollectionInitDateMsg() {
        return collectionInitDateMsg;
    }

    @Override
    public String getCollectionSizeMsg() {
        return collectionSizeMsg;
    }

    @Override
    public String getInputNameMsg() {
        return inputNameMsg;
    }

    @Override
    public String getInputCoordinatesXMsg() {
        return inputCoordinatesXMsg;
    }

    @Override
    public String getInputCoordinatesYMsg() {
        return inputCoordinatesYMsg;
    }

    @Override
    public String getInputPriceMsg() {
        return inputPriceMsg;
    }

    @Override
    public String getInputTicketTypeMsg() {
        return inputTicketTypeMsg;
    }

    @Override
    public String getInputVenueNameMsg() {
        return inputVenueNameMsg;
    }

    @Override
    public String getInputVenueCapacityMsg() {
        return inputVenueCapacityMsg;
    }

}

