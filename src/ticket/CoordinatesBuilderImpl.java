package ticket;

import exceptions.InvalidFieldException;
import messages.Messenger;

/**
 * Реализация интерфеса CoordinatesBuilder
 */
public class CoordinatesBuilderImpl implements CoordinatesBuilder{
    private Integer x; //Значение поля должно быть больше -27, Поле не может быть null
    private double y; //Значение поля должно быть больше -279
    private CoordinatesValidator validator;
    private Messenger messenger;

    /**
     * @param messenger мессенджер
     */
    public CoordinatesBuilderImpl(Messenger messenger){
        validator = new CoordinatesValidatorImpl();
        this.messenger = messenger;
    }

    @Override
    public void setX(Integer x) throws InvalidFieldException {
        if (validator.validateCoordinatesX(x)) {
            this.x = x;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidCoordinatesX"));
        }
    }

    @Override
    public void setY(double y) throws InvalidFieldException {
        if (validator.validateCoordinatesY(y)) {
            this.y = y;
        } else {
            throw new InvalidFieldException(messenger.getExceptionMsg("invalidCoordinatesY"));
        }
    }

    @Override
    public Coordinates getCoordinates(){
        return new Coordinates(x, y);
    }
}
