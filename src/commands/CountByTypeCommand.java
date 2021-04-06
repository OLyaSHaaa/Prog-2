package commands;

import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import messages.Messenger;
import output.OutputManager;
import ticket.TicketType;

import java.util.Comparator;

/**
 * Класс команды, которая выводит количество элементов, значение поля type которых равно заданному
 */
public class CountByTypeCommand implements Command, RequiringArg<TicketType>{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;
    private TicketType arg;

    /**
     * @param collectionManager менеджер коллекции
     * @param messenger мессенджер
     * @param outputManager менеджер вывода
     */
    public CountByTypeCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute() {
        long count = collectionManager.getTicketsStream()
                    .filter(ticket -> ticket.getTicketType() == arg)
                    .count();
        outputManager.printMsg(count + "\n");
    }

    @Override
    public void setArg(TicketType arg) {
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(CommandInvoker commandInvoker) throws NoArgException, InvalidArgumentTypeException {
        commandInvoker.setTicketTypeArg(this);
        commandInvoker.invokeCommand(this);
    }
}
