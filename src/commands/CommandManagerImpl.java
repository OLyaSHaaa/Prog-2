package commands;

import application.Application;
import collectionManager.CollectionManager;
import exceptions.InvalidArgumentTypeException;
import exceptions.NoArgException;
import exceptions.NoSuchCommandException;
import input.InputManager;
import messages.Messenger;
import output.OutputManager;

import java.util.*;

    /**
     * Реализация интерфеса CommandManager
     */
    public class CommandManagerImpl implements CommandManager {
        private Map<String, Command> commandMap;
        private Stack<String> history = new Stack<>();
        private static Set<String> usedScripts = new HashSet<>();
        private CommandInvoker commandInvoker;
        private Messenger messenger;
        private OutputManager outputManager;

        public CommandManagerImpl(CollectionManager collectionManager, Application app, Messenger messenger,
                                  OutputManager outputManager, InputManager inputManager){
            this.outputManager = outputManager;
            this.messenger = messenger;
            commandMap = new HashMap<>();
            commandInvoker = new CommandInvokerImpl(messenger);
            commandMap.put("help", new HelpCommand(commandMap.keySet(), messenger, outputManager));
            commandMap.put("info", new InfoCommand(collectionManager, messenger, outputManager));
            commandMap.put("show", new ShowCommand(collectionManager, messenger, outputManager));
            commandMap.put("add", new AddCommand(collectionManager, inputManager));
            commandMap.put("update", new UpdateCommand(collectionManager, messenger, inputManager, outputManager));
            commandMap.put("remove_by_id", new RemoveByIdCommand(collectionManager, messenger, outputManager));
            commandMap.put("clear", new ClearCommand(collectionManager));
            commandMap.put("save", new SaveCommand(collectionManager));
            commandMap.put("execute_script", new ExecuteScriptCommand(messenger, outputManager, collectionManager, app));
            commandMap.put("exit", new ExitCommand(app));
            commandMap.put("add_if_max",new AddIfMaxCommand(collectionManager,inputManager));
            commandMap.put("remove_lower", new RemoveLowerCommand(collectionManager,inputManager));
            commandMap.put("history", new HistoryCommand(history, outputManager));
            commandMap.put("group_counting_by_price",new GroupCountingByPriceCommand(collectionManager,outputManager));
            commandMap.put("count_by_type", new CountByTypeCommand(collectionManager,messenger,outputManager));
            commandMap.put("filter_greater_than_type", new FilterGreaterThanTypeCommand(collectionManager,messenger,outputManager));

//
        }

        @Override
        public void executeCommand(String command, String arg) throws NoSuchCommandException {
            if (command.equals(""))
                return;
            if (commandMap.containsKey(command)) {
                commandInvoker.setArg(arg);
                try {
                    commandMap.get(command).acceptInvoker(commandInvoker);
                } catch (NoArgException | InvalidArgumentTypeException e) {
                    outputManager.printErrorMsg(e.getMessage() + "\n");
                    return;
                }
                history.push(command);
                if (history.size() > 9) {
                    history.remove(0);
                }
            } else {
                throw new NoSuchCommandException(messenger.getExceptionMsg("noSuchCommand") + ": " + command);
            }
        }

        @Override
        public void usedScriptAdd(String scriptName){
            usedScripts.add(scriptName);
        }

        @Override
        public boolean scriptIsUsed(String scriptName){
            return usedScripts.contains(scriptName);
        }

        public void usedScriptRemove(String scriptName){
            usedScripts.remove(scriptName);
        }

        @Override
        public void clearUsedScripts(){
            usedScripts.clear();
        }

    }
