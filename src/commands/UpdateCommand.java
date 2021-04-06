package commands;

import collectionManager.CollectionManager;
import collectionManager.TicketIdManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import input.InputManager;
import messages.Messenger;
import output.OutputManager;
import ticket.Ticket;

/**
 * Класс команды, которая обновляет значение элемента коллекции, id которого равен заданному
 */
public class UpdateCommand implements Command, RequiringArg<Long>{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private InputManager inputManager;
    private OutputManager outputManager;
    private Long arg;

    /**
     * @param collectionManager менеджер коллекции
     * @param messenger мессенджер
     * @param inputManager менджер ввода
     * @param outputManager менеджер вывода
     */
    public UpdateCommand(CollectionManager collectionManager, Messenger messenger, InputManager inputManager, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public void execute() {
        if (!TicketIdManager.getInstance().idIsFree(arg)){
            TicketIdManager.getInstance().removeId(arg);
            Ticket oldTicket = collectionManager.getTicketsStream().filter(person -> person.getId() == arg).findAny().get();
            Ticket ticket = inputManager.readTicket( oldTicket.getId(), oldTicket.getCreationDate(),oldTicket.getVenue().getId());
            collectionManager.removeElement(arg);
            collectionManager.addElement(ticket);
        } else {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noSuchId") + "\n");
        }
    }

    @Override
    public void setArg(Long arg) {
        this.arg = arg;
    }

    @Override
    public void acceptInvoker(CommandInvoker commandInvoker) throws NoArgException, InvalidArgumentTypeException {
        commandInvoker.setLongArg(this);
        commandInvoker.invokeCommand(this);
    }
}
