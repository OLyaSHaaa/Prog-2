package exceptions;

public class NotUniqueIdException extends InvalidFieldException {
    public NotUniqueIdException(String msg){
        super(msg);
    }
}