package ticket;

public class Venue {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer capacity; //Поле не может быть null, Значение поля должно быть больше 0

    /**
     * @param id номер места проведения
     * @param name название места проведения
     * @param capacity вместимость багажа
     */

    public Venue (Integer id, String name, Integer capacity){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * @return номер места проведения
     */
    public Integer getId() { return  id;}

    /**
     * @return название места проведения
     */
    public String getName() { return name;}

    /**
     * @return вместимость багажа
     */
    public Integer getCapacity() { return capacity;}

}
