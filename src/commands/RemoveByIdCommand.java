package commands;

import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import messages.Messenger;
import output.OutputManager;

/**
 * Класс команды, которая удаляет элемент из коллекции по его id
 */
public class RemoveByIdCommand implements Command, RequiringArg<Long>{
    private CollectionManager collectionManager;
    private Messenger messenger;
    private OutputManager outputManager;
    private Long arg;

    /**
     * @param collectionManager менеджер коллекции
     * @param messenger мессенджер
     * @param outputManager менеджер вывода
     */
    public RemoveByIdCommand(CollectionManager collectionManager, Messenger messenger, OutputManager outputManager){
        this.collectionManager = collectionManager;
        this.messenger = messenger;
        this.outputManager = outputManager;
    }

    @Override
    public void execute() {
        if(!collectionManager.removeElement((long) arg)){
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
