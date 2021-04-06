package commands;

import collectionManager.CollectionManager;
import input.InputManager;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс команды, которая добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего
 * элемента этой коллекции
 */
public class RemoveLowerCommand implements Command{
    private CollectionManager collectionManager;
    private InputManager inputManager;

    /**
     * @param collectionManager менеджер коллекции
     * @param inputManager менеджер ввода
     */
    public RemoveLowerCommand(CollectionManager collectionManager, InputManager inputManager){
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
    }

    @Override
    public void execute() {
        Ticket ticket = inputManager.readTicket();
        List<Long> identifiers = new LinkedList<>();
        collectionManager.getTicketsStream()
                .filter(ticket1 -> ticket1.compareTo(ticket) < 0)
                .forEach(ticket1 -> identifiers.add(ticket1.getId()));
        for (long id: identifiers){
            collectionManager.removeElement(id);
        }
    }
}

