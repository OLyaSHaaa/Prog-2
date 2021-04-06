package commands;

import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
        import messages.Messenger;
        import output.OutputManager;
import ticket.TicketType;

import java.util.Comparator;

/**
 * Класс команды, которая выводит элементы, значение поля name которых содержит заданную подстроку
 */
public class FilterGreaterThanTypeCommand implements Command, RequiringArg<TicketType>{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;
    private TicketType arg;

    /**
     * @param collectionManager менеджер коллекции
     * @param messenger мессенджер
     * @param outputManager менеджер вывода
     */
    public FilterGreaterThanTypeCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute() {
        collectionManager.getTicketsStream()
                .filter(ticket -> ticket.getTicketType().getTypeCode() > arg.getTypeCode())
                .forEachOrdered(ticket -> outputManager.printMsg(messenger.getTicketString(ticket)+ "\n"));
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
