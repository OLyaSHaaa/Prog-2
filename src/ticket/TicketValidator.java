package ticket;

import java.time.LocalDateTime;


public interface TicketValidator {

    /**
     * @param id идентификатор
     * @return true - корректно, false - некорректно
     */
    boolean validateId(Long id);

    /**
     * @param name имя
     * @return true - корректно, false - некорректно
     */
    boolean validateName(String name);

    /**
     * @param coordinates координаты
     * @return true - корректно, false - некорректно
     */
    boolean validateCoordinates(Coordinates coordinates);

    /**
     * @param creationDate дата создания
     * @return true - корректно, false - некорректно
     */
    boolean validateCreationDate(LocalDateTime creationDate);

    /**
     * @param price цена
     * @return true - корректно, false - некорректно
     */
    boolean validatePrice(long price);

    /**
     * @param ticketType тип билета
     * @return true - корректно, false - некорректно
     */
    boolean validateTicketType(TicketType ticketType);

    /**
     * @param venue место встречи
     * @return true - корректно, false - некорректно
     */
    boolean validateVenue(Venue venue);
}