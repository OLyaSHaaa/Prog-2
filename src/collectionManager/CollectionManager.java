package collectionManager;

import exceptions.BrokenDataException;
import exceptions.InvalidFieldException;
import exceptions.NoDataException;
import exceptions.NoEnvVarException;
import ticket.Ticket;

import java.time.LocalDate;
import java.util.stream.Stream;

public interface CollectionManager {

    /**
     * @return тип коллекции
     */
    Class getType();

    /**
     * @return количество элементов коллекции
     */
    int getSize();

    /**
     * @return дата инициализации коллекции
     */
    LocalDate getInitDate();

    /**
     * Метод, который добавляет элемент в коллекцию
     * @param ticket элемент
     */
    void addElement(Ticket ticket);

    /**
     * Удаление элемента из коллекции по его id
     * @param id значение поля id элемента
     * @return true, если элемент был найден и удален; false, если не был удален
     */
    boolean removeElement(Long id);

    /**
     * Метод, который очищает коллекцию
     */
    void clear();

    /**
     * Метод, который загружает объекты Person в коллекцию, используя DataManager
     * @throws NoEnvVarException если отсутсвует переменная окружения, указывающая имя файла
     * @throws InvalidFieldException если какое-то из полей имеет неверный формат или неверный тип данных
     * @throws NoDataException если отсутсвует хранилище данных
     * @throws BrokenDataException если хранилище данных сломано
     */
    void loadTickets() throws NoEnvVarException, InvalidFieldException, NoDataException, BrokenDataException;

    /**
     * Метод, который сохраняет коллекцию
     */
    void saveTickets();

    /**
     * @return объект Stream коллекции элементов
     */
    Stream<Ticket> getTicketsStream();

}
