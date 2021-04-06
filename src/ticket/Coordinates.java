package ticket;

/**
 * Класс координат
 */
public class Coordinates {
    private Integer x; //Значение поля должно быть больше -27, Поле не может быть null
    private double y; //Значение поля должно быть больше -279
    /**
     * @param x координата x
     * @param y координата y
     */
    public Coordinates(Integer x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return координата x
     */
    public Integer getX() {
        return x;
    }

    /**
     * @return координата y
     */
    public double getY() {
        return y;
    }
}
