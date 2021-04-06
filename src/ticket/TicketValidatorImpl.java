package ticket;

import java.time.LocalDateTime;

/**
 * Реализация интерфейса TicketValidator
 */
public class TicketValidatorImpl implements TicketValidator{


    @Override
    public boolean validateId(Long id) {
        return id != null && id > 0;
    }

    @Override
    public boolean validateName(String name) {
        return name != null && name.length() > 0;
    }

    @Override
    public boolean validateCoordinates(Coordinates coordinates) {
        return coordinates != null;
    }

    @Override
    public boolean validateCreationDate(LocalDateTime creationDate) {
        return creationDate != null;
    }

    @Override
    public boolean validatePrice(long price) {
        return price > 0;
    }

    @Override
    public boolean validateTicketType(TicketType ticketType) {
        return ticketType != null;
    }

    @Override
    public boolean validateVenue(Venue venue) {
        return venue != null;
    }
}
