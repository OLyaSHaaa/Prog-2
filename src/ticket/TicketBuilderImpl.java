package ticket;

import collectionManager.IdManager;
import collectionManager.TicketIdManager;
import exceptions.InvalidFieldException;
import messages.Messenger;

import java.time.LocalDateTime;


/**
 * Реализация интерфеса TicketBuilder
 */
public class TicketBuilderImpl implements TicketBuilder{
    private IdManager<Long> idManager;
    private Long ticketId; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private CoordinatesBuilder coordinatesBuilder; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long price; //Значение поля должно быть больше 0
    private TicketType ticketType; //Поле может быть null
    private VenueBuilder venueBuilder; //Поле не может быть null
    private TicketValidator ticketValidator;
    private VenueValidator venueValidator;
    private Messenger messenger;

    /**
     * @param messenger мессенджер
     */
    public TicketBuilderImpl(Messenger messenger){
        idManager = TicketIdManager.getInstance();
        ticketValidator = new TicketValidatorImpl();
        this.messenger = messenger;
    }


    @Override
    public void setId() {
        ticketId = idManager.getFreeId();
        idManager.addId(ticketId);
    }

    @Override
    public void setId(Long id) throws InvalidFieldException {
        if (ticketValidator.validateId(id) && idManager.idIsFree(id)){
            this.ticketId = id;
            idManager.addId(ticketId);
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidId"));
        }
    }

    @Override
    public void setName(String name) throws InvalidFieldException {
        if (ticketValidator.validateName(name)){
            this.name = name;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidName"));
        }
    }

    @Override
    public void setCoordinatesX(int x) throws InvalidFieldException {
        if (coordinatesBuilder == null){
            coordinatesBuilder = new CoordinatesBuilderImpl(messenger);
        }
        coordinatesBuilder.setX(x);
    }

    @Override
    public void setCoordinatesY(Double y) throws InvalidFieldException {
        if (coordinatesBuilder == null){
            coordinatesBuilder = new CoordinatesBuilderImpl(messenger);
        }
        coordinatesBuilder.setY(y);
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) throws InvalidFieldException {
        if (ticketValidator.validateCreationDate(creationDate)){
            this.creationDate = creationDate;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidCreationDate"));
        }
    }

    @Override
    public void setPrice(long price) throws InvalidFieldException {
        if (ticketValidator.validatePrice(price)){
            this.price = price;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidPrice"));
        }
    }

    @Override
    public void setTicketType(TicketType ticketType) throws InvalidFieldException {
        if (ticketValidator.validateTicketType(ticketType)){
            this.ticketType = ticketType;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidTicketType"));
        }
    }

    @Override
    public void setVenueId() {
        if (venueBuilder == null){
            venueBuilder = new VenueBuilderImpl(messenger);
        }
        venueBuilder.setId();
    }

    @Override
    public void setVenueId(int id) throws InvalidFieldException {
        if (venueBuilder == null){
            venueBuilder = new VenueBuilderImpl(messenger);
        }
        venueBuilder.setId(id);
    }

    @Override
    public void setVenueName(String name) throws InvalidFieldException {
        if (venueBuilder == null){
            venueBuilder = new VenueBuilderImpl(messenger);
        }
        venueBuilder.setName(name);
    }

    @Override
    public void setVenueCapacity(int capacity) throws InvalidFieldException {
        if (venueBuilder == null){
            venueBuilder = new VenueBuilderImpl(messenger);
        }
        venueBuilder.setCapacity(capacity);
    }

    @Override
    public Ticket getTicket() {
        if (!ticketValidator.validateCreationDate(creationDate)) creationDate = LocalDateTime.now();
        return new Ticket(ticketId, name, coordinatesBuilder.getCoordinates(), creationDate, price, ticketType,
                venueBuilder.getVenue());
    }
}
