package commands;

import collectionManager.CollectionManager;
import input.InputManager;
import ticket.Ticket;

/**
 * Класс команды, которая добавляет новый элемент в коллекцию,
 * если его значение превышает значение наибольшего элемента этой коллекции
 */
public class AddIfMaxCommand implements Command{
    private CollectionManager collectionManager;
    private InputManager inputManager;

    /**
     * @param collectionManager менеджер коллекции
     * @param inputManager менеджер ввода
     */
    public AddIfMaxCommand(CollectionManager collectionManager, InputManager inputManager){
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
    }

    @Override
    public void execute() {
        Ticket ticket = inputManager.readTicket();
        if (ticket.compareTo(collectionManager.getTicketsStream().max(Ticket::compareTo).get()) >= 0)
            collectionManager.addElement(ticket);
    }
}

