package ticket;

import exceptions.InvalidFieldException;


public interface CoordinatesBuilder {

    /**
     * Задать координату x
     * @param x координата x
     * @throws InvalidFieldException если значение некорректно
     */
    void setX(Integer x) throws InvalidFieldException;

    /**
     * Задать координату y
     * @param y координата y
     * @throws InvalidFieldException если значение некорректно
     */
    void setY(double y) throws InvalidFieldException;

    /**
     * @return объект Coordinates
     */
    Coordinates getCoordinates();
}

