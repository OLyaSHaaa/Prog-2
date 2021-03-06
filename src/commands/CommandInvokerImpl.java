package commands;

import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import messages.Messenger;
import ticket.TicketType;

/**
 * Реализация интерфейса CommandInvoker
 */
public class CommandInvokerImpl implements CommandInvoker{
    private String arg;
    private Messenger messenger;

    /**
     * @param messenger мессенджер
     */
    public CommandInvokerImpl(Messenger messenger){
        this.messenger = messenger;
    }

    @Override
    public void invokeCommand(Command command) {
        command.execute();
    }

    @Override
    public void setLongArg(RequiringArg<Long> command) throws InvalidArgumentTypeException, NoArgException {
        if (!arg.equals("")) {
            try {
                command.setArg(Long.parseLong(arg));
            } catch (NumberFormatException e) {
                throw new InvalidArgumentTypeException(messenger.getExceptionMsg("noLong"));
            }
        } else {
            throw new NoArgException(messenger.getExceptionMsg("noArg"));
        }
    }

    @Override
    public void setStringArg(RequiringArg<String> command) throws NoArgException {
        if (!arg.equals("")){
            command.setArg(arg);
        } else {
            throw new NoArgException(messenger.getExceptionMsg("noArg"));
        }
    }

    @Override
    public void setTicketTypeArg(RequiringArg<TicketType> command) throws InvalidArgumentTypeException, NoArgException {
        if (!arg.equals("")) {
            try {
                command.setArg(TicketType.valueOf(arg.toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new InvalidArgumentTypeException(messenger.getExceptionMsg("noEnum"));
            }
        } else {
            throw new NoArgException(messenger.getExceptionMsg("noArg"));
        }
    }

    @Override
    public void setArg(String arg) {
        this.arg = arg;
    }
}
