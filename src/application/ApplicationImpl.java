package application;

import collectionManager.CollectionManager;
import collectionManager.TicketCollectionManager;
import collectionManager.TicketIdManager;
import collectionManager.VenueIdManager;
import commands.CommandManager;
import commands.CommandManagerImpl;
import exceptions.*;
import dataManager.*;
import input.ConsoleInputManager;
import input.InputManager;
import messages.*;
import output.ConsoleOutputManager;
import output.OutputManager;

import java.util.NoSuchElementException;

/**
 * Реализация интерфейса Application
 */
public class ApplicationImpl implements Application{
    private boolean exit;
    private OutputManager outputManager;
    private InputManager inputManager;
    private Messenger messenger;
    private CommandManager commandManager;

    public ApplicationImpl(){
        exit = false;
    }

    @Override
    public void start(){
        messenger = new MessengerImpl( new CommandMessagesImpl(), new ExceptionMessagesImpl(), new CollectionMessagesImpl());
        outputManager = new ConsoleOutputManager();
        inputManager = new ConsoleInputManager(messenger, outputManager);
        String fileName = System.getenv("Lab5");
        DataReader dataReader = new JSONTicketReader(fileName);
        DataWriter dataWriter = new JSONTicketWriter(fileName);
        DataManager dataManager = new DataManagerImpl(dataReader, dataWriter, messenger);
        CollectionManager collectionManager = new TicketCollectionManager(dataManager);
        try {
            collectionManager.loadTickets();
        } catch (NoEnvVarException e){
            outputManager.printErrorMsg(messenger.getExceptionMsg("noEnvVar") + "\n");
        } catch (BrokenDataException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("brokenData") + "\n");
            TicketIdManager.getInstance().clearIdentifiers();
            VenueIdManager.getInstance().clearIdentifiers();
        } catch (InvalidFieldException e) {
            outputManager.printErrorMsg(e.getMessage() + "\n");
            TicketIdManager.getInstance().clearIdentifiers();
            VenueIdManager.getInstance().clearIdentifiers();
        } catch (NoDataException e) {
            outputManager.printErrorMsg(messenger.getExceptionMsg("noData") + "\n");
        }
        this.commandManager = new CommandManagerImpl(collectionManager, this, messenger, outputManager, inputManager);
        outputManager.printMsg(messenger.getStartMsg() + "\n");
        run();
        outputManager.printMsg(messenger.getFinishMsg()  + "\n");
    }

    private void run(){
        while (!exit){
            try {
                String inputString = inputManager.readCommand();
                String[] input = inputString.split("\\s+", 2);
                if (input.length < 2)
                    commandManager.executeCommand(input[0], "");
                else
                    commandManager.executeCommand(input[0], input[1]);
            } catch (NoSuchCommandException | ScriptRecursionException e) {
                outputManager.printErrorMsg(e.getMessage() + "\n");
            } catch (NoSuchElementException e){
                outputManager.printErrorMsg(messenger.getExceptionMsg("noSuchElement") + "\n");
                exit();
            }
        }
    }

    @Override
    public void exit(){
        exit = true;
    }
}
