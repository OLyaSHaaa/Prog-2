package messages;

/**
 * Реализация интерфейса CommandMessages
 */
public class CommandMessagesImpl implements CommandMessages{
    private final String addDescription;
    private final String clearDescription;
    private final String executeScriptDescription;
    private final String exitDescription;
    private final String helpDescription;
    private final String historyDescription;
    private final String infoDescription;
    private final String removeByIdDescription;
    private final String saveDescription;
    private final String showDescription;
    private final String updateDescription;
    private final String removeLowerDescription;
    private final String groupCountingByPriceDescription;
    private final String filterGreaterThanTypeDescription;
    private final String addIfMaxDescription;
    private final String countByTypeDescription;

    public CommandMessagesImpl() {
        addDescription = "add {element} : добавить новый элемент в коллекцию";
        clearDescription = "clear : очистить коллекцию";
        executeScriptDescription = "execute_script file_name : считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
        exitDescription = "exit : завершить программу (без сохранения в файл)";
        helpDescription = "help : вывести справку по доступным командам";
        historyDescription = "history : вывести последние 9 команд (без их аргументов)";
        infoDescription = "info : вывести в стандартный поток вывода информацию о коллекции";
        removeByIdDescription = "remove_by_id id : удалить элемент из коллекции по его id";
        saveDescription = "save : сохранить коллекцию в файл";
        showDescription = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
        updateDescription = "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
        addIfMaxDescription = "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает " +
                                    "значение наибольшего элемента этой коллекции";
        countByTypeDescription = "count_by_type type : вывести количество элементов, значение" +
                                    " поля type которых равно заданному";
        removeLowerDescription ="remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
        groupCountingByPriceDescription = "group_counting_by_price : сгруппировать элементы коллекции по значению поля price, " +
                                    "вывести количество элементов в каждой группе";
        filterGreaterThanTypeDescription = "filter_greater_than_type type : вывести элементы, значение поля type которых больше заданного";

    }

    @Override
    public String getAddDescription() {
        return addDescription;
    }

    @Override
    public String getClearDescription() {
        return clearDescription;
    }

    @Override
    public String getExecuteScriptDescription() {
        return executeScriptDescription;
    }

    @Override
    public String getExitDescription() {
        return exitDescription;
    }

    @Override
    public String getHelpDescription() {
        return helpDescription;
    }

    @Override
    public String getHistoryDescription() {
        return historyDescription;
    }

    @Override
    public String getInfoDescription() {
        return infoDescription;
    }

    @Override
    public String getRemoveByIdDescription() {
        return removeByIdDescription;
    }

    @Override
    public String getSaveDescription() {
        return saveDescription;
    }

    @Override
    public String getShowDescription() {
        return showDescription;
    }

    @Override
    public String getUpdateDescription() {
        return updateDescription;
    }

    @Override
    public String getRemoveLowerDescription() {
        return removeLowerDescription;
    }

    @Override
    public String getGroupCountingByPriceDescription() {
        return groupCountingByPriceDescription;
    }

    @Override
    public String getFilterGreaterThanTypeDescription() {
        return filterGreaterThanTypeDescription;
    }

    @Override
    public String getAddIfMaxDescription() {
        return addIfMaxDescription;
    }

    @Override
    public String getCountByTypeDescription() {
        return countByTypeDescription;
    }
}

