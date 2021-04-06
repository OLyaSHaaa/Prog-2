package dataManager;

import exceptions.BrokenDataException;
import exceptions.InvalidFieldException;
import exceptions.NoDataException;
import exceptions.NoEnvVarException;
import messages.Messenger;
import ticket.Ticket;

import java.util.Collection;
import java.util.HashSet;


public interface DataReader {

    /**
     * Метод, который читает коллекцию
     * @return коллекция
     * @throws NoEnvVarException при отсутсвии переменной окружения
     * @throws InvalidFieldException при некорректном поле объекта
     * @throws NoDataException при отсутствии данных
     * @throws BrokenDataException при некорректных данных
   \\  * @param messenger
     * @param messenger
     */
    HashSet<Ticket> readElements(Messenger messenger)  throws InvalidFieldException, NoEnvVarException, NoDataException, BrokenDataException;
}
