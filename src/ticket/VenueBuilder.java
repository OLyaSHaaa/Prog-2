package ticket;

import exceptions.InvalidFieldException;


public interface VenueBuilder {

    void setId();

    /**
     * Задать место встречи
     * @param id номер места проведения
     */
    void setId(Integer id) throws InvalidFieldException;;

    /**
     * Задать название места встречи
     * @param name название места встречи
     */
    void setName(String name) throws InvalidFieldException;

    /**
     * Задать вместимость
     * @param capacity вместимость
     * @throws InvalidFieldException если значение некорректно
     */
    void setCapacity(Integer capacity) throws InvalidFieldException;;

    /**
     * @return объект Venue
     */
    Venue getVenue();
}

