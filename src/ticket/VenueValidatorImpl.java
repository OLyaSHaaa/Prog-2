package ticket;

/**
 * Реализация интерфейса VenueValidator
 */
public class VenueValidatorImpl implements VenueValidator{

    @Override
    public boolean validateVenueId(Integer id) {
        return id != null && id > 0;
    }

    @Override
    public boolean validateVenueName(String name) {
        return name != null && name.length() > 0;
    }

    @Override
    public boolean validateVenueCapacity(Integer capacity) {
        return capacity != null && capacity > 0;
    }
}