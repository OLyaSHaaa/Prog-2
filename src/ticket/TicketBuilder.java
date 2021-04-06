package ticket;


import exceptions.InvalidFieldException;

import java.time.LocalDateTime;

public interface TicketBuilder {

    /**
     * Сгенерировать id
     */
    void setId();

    /**
     * Задать идентификатор
     *
     * @param id идентификатор
     * @throws InvalidFieldException если значение некорректно
     */
    void setId(Long id) throws InvalidFieldException;

    /**
     * Задать имя
     *
     * @param name имя
     * @throws InvalidFieldException если значение некорректно
     */
    void setName(String name) throws InvalidFieldException;

    /**
     * Задать координату x
     *
     * @param x координата x
     * @throws InvalidFieldException если значение некорректно
     */
    void setCoordinatesX(int x) throws InvalidFieldException;

    /**
     * Задать координату y
     *
     * @param y координата y
     * @throws InvalidFieldException если значение некорректно
     */
    void setCoordinatesY(Double y) throws InvalidFieldException;

    /**
     * Задать дату создания
     *
     * @param creationDate дата создания
     * @throws InvalidFieldException если значение некорректно
     */
    void setCreationDate(LocalDateTime creationDate) throws InvalidFieldException;

    /**
     * Установить стоимость
     *
     * @param price стоимость билета
     * @throws InvalidFieldException если значение некорректно
     */
    void setPrice(long price) throws InvalidFieldException;

    /**
     * Задать тип билета
     *
     * @param ticketType тип билета
     * @throws InvalidFieldException если значение некорректно
     */
    void setTicketType(TicketType ticketType) throws InvalidFieldException;

    void setVenueId();

    /**
     * Задать место встречи по id
     * @param id id места встречи
     * @throws InvalidFieldException если значение некорректно
     */
    void setVenueId(int id) throws InvalidFieldException;

    /**
     * Задать название места проведения
     * @param  name название места проведения
     * @throws InvalidFieldException если значение некорректно
     */
    void setVenueName(String name) throws  InvalidFieldException;

    /**
     * Задать параметры вместимости
     * @param  capacity вместмость багажа
     * @throws InvalidFieldException если значение некорректно
     */
    void setVenueCapacity(int capacity) throws InvalidFieldException;

    /**
     * @return объект Ticket
     */
    Ticket getTicket();




}