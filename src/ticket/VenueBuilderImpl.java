package ticket;

import collectionManager.IdManager;
import collectionManager.VenueIdManager;
import exceptions.InvalidFieldException;
import messages.Messenger;

/**
 * Реализация интерфеса VenueBuilder
 */
public class VenueBuilderImpl implements VenueBuilder{
    private IdManager<Integer> idManager;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer capacity; //Поле не может быть null, Значение поля должно быть больше 0
    private VenueValidator validator;
    private Messenger messenger;

    /**
     * @param messenger мессенджер
     */
    public VenueBuilderImpl(Messenger messenger){
        validator = new VenueValidatorImpl();
        this.messenger = messenger;
        idManager = VenueIdManager.getInstance();
    }

    @Override
    public void setId() {
        id = idManager.getFreeId();
        idManager.addId(id);
    }

    @Override
    public void setId(Integer id) throws InvalidFieldException {
        if (validator.validateVenueId(id)){
            this.id = id;
            idManager.addId(id);
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidVenueId"));
        }
    }

    @Override
    public void setName(String name) throws InvalidFieldException {
        if (validator.validateVenueName(name)){
            this.name = name;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidVenueName"));
        }
    }

    @Override
    public void setCapacity(Integer capacity) throws InvalidFieldException {
        if (validator.validateVenueCapacity(capacity)){
            this.capacity = capacity;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidVenueCapacity"));
        }
    }

    @Override
    public Venue getVenue() {
        return new Venue(id, name, capacity);
    }

}
