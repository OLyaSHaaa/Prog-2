package ticket;


public interface VenueValidator  {

    /**
     * @param id номер места проведения
     * @return true - корректно, false - некорректно
     */
    boolean validateVenueId(Integer id);

    /**
     * @param name название места проведения
     * @return true - корректно, false - некорректно
     */
    boolean validateVenueName(String name);

    /**
     * @param capacity вместимость багажа
     * @return true - корректно, false - некорректно
     */
    boolean validateVenueCapacity(Integer capacity);


}
