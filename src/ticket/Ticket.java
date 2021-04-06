package ticket;

import java.time.LocalDateTime;

/**
 * Класс билета
 */
public class Ticket implements Comparable<Ticket>{
    private  final long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private  final String name; //Поле не может быть null, Строка не может быть пустой
    private  final Coordinates coordinates; //Поле не может быть null
    private  final java.time.LocalDateTime creationDate;  //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private  final long price; //Значение поля должно быть больше 0
    private  final TicketType ticketType; //Поле может быть null
    private final Venue venue; //Поле не может быть null

/**
 * Конструктор
 * @param id идентификатор
 * @param name имя
 * @param coordinates координаты
 * @param creationDate дата создания
 * @param price цена билета
 * @param ticketType тип билета
 * @param venue вместимость багажа
 */
Ticket(long id, String name, Coordinates coordinates, LocalDateTime creationDate, long price, TicketType ticketType, Venue venue) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.creationDate = creationDate;
    this.price = price;
    this.ticketType = ticketType;
    this.venue = venue;
}

    /**
     * @return идентификатор
     */
    public long getId() {
        return id;
    }

    /**
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * @return координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return дата создания
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * @return цена билета
     */
    public long getPrice () { return price;}

    /**
     * @return тип билета
     */
    public TicketType getTicketType(){ return ticketType;}

    /**
     * @return место встречи
     */
    public Venue getVenue() {
        return venue;
    }



    @Override
    public int compareTo(Ticket t){
        return Long.compare(price, t.price);
    }
}














