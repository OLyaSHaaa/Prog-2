package messages;


import exceptions.NoMsgException;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchFieldException;
import ticket.Ticket;

/**
 * Реализация интерфеса мессенджера
 */
public class MessengerImpl implements Messenger {
    private CommandMessages commandMessages;
    private ExceptionMessages exceptionMessages;
    private CollectionMessages collectionMessages;
    private String startMsg;
    private String finishMsg;

    /**
     * @param commandMessages    сообщения команд
     * @param exceptionMessages  сообщения ошибок
     * @param collectionMessages сообщения коллекции
     */
    public MessengerImpl(CommandMessages commandMessages, ExceptionMessages exceptionMessages, CollectionMessages collectionMessages) {
        this.commandMessages = commandMessages;
        this.exceptionMessages = exceptionMessages;
        this.collectionMessages = collectionMessages;
        startMsg = "Program started : input command";
        finishMsg = "Program finished";
    }

    @Override
    public String getStartMsg() {
        return startMsg;
    }

    @Override
    public String getFinishMsg() {
        return finishMsg;
    }

    @Override
    public String getExceptionMsg(String msgName) {
        switch (msgName) {
            case "invalidId":
                return exceptionMessages.getInvalidIdMsg();

            case "notUniqueId":
                return exceptionMessages.getNotUniqueIdMsg();

            case "noIdLeft":
                return exceptionMessages.getNoIdLeftMsg();

            case "invalidName":
                return exceptionMessages.getInvalidNameMsg();

            case "invalidCoordinates":
                return exceptionMessages.getInvalidCoordinatesMsg();

            case "invalidCoordinatesX":
                return exceptionMessages.getInvalidCoordinatesXMsg();

            case "invalidCoordinatesY":
                return exceptionMessages.getInvalidCoordinatesYMsg();

            case "invalidCreationDate":
                return exceptionMessages.getInvalidCreationDateMsg();

            case "invalidPrice":
                return exceptionMessages.getInvalidPriceMsg();

            case "invalidTicketType":
                return exceptionMessages.getInvalidTicketTypeMsg();

            case "invalidVenueId":
                return exceptionMessages.getInvalidVenueIdMsg();

            case "invalidVenueName":
                return exceptionMessages.getInvalidVenueNameMsg();

            case "invalidVenueCapacity":
                return exceptionMessages.getInvalidVenueCapacityMsg();

            case "noInteger":
                return exceptionMessages.getNoIntegerMsg();

            case "noLong":
                return exceptionMessages.getNoLongMsg();

            case "noDate":
                return exceptionMessages.getNoDateMsg();

            case "noEnum":
                return exceptionMessages.getNoEnumMsg();

            case "noArg":
                return exceptionMessages.getNoArgMsg();

            case "brokenData":
                return exceptionMessages.getBrokenDataMsg();

            case "noEnvVar":
                return exceptionMessages.getNoEnvVarMsg();

            case "noData":
                return exceptionMessages.getNoDataMsg();

            case "wrongFieldType":
                return exceptionMessages.getWrongFieldTypeMsg();

            case "noSuchCommand":
                return exceptionMessages.getNoSuchCommandMsg();

            case "noSuchId":
                return exceptionMessages.getNoSuchIdMsg();

            case "noSuchField":
                return exceptionMessages.getNoSuchFieldMsg();

            case "noSuchElement":
                return exceptionMessages.getNoSuchElementMsg();

            case "script":
                return exceptionMessages.getScriptMsg();

            case "noFile":
                return exceptionMessages.getNoFileMsg();

            case "scriptRecursion":
                return exceptionMessages.getScriptRecursionMsg();

            default:
                throw new NoMsgException(exceptionMessages.getNoMsgMsg());
        }
    }

    @Override
    public String getCommandDescription(String commandName) throws NoSuchCommandException {
        switch (commandName) {
            case "add":
                return commandMessages.getAddDescription();

            case "clear":
                return commandMessages.getClearDescription();

            case "execute_script":
                return commandMessages.getExecuteScriptDescription();

            case "exit":
                return commandMessages.getExitDescription();

            case "add_if_max":
                return commandMessages.getAddIfMaxDescription();

            case "remove_lower":
                return commandMessages.getRemoveLowerDescription();

            case "help":
                return commandMessages.getHelpDescription();

            case "history":
                return commandMessages.getHistoryDescription();

            case "info":
                return commandMessages.getInfoDescription();

            case "remove_by_id":
                return commandMessages.getRemoveByIdDescription();

            case "save":
                return commandMessages.getSaveDescription();

            case "show":
                return commandMessages.getShowDescription();

            case "update":
                return commandMessages.getUpdateDescription();

            case "filter_greater_than_type":
                return commandMessages.getFilterGreaterThanTypeDescription();

            case "group_counting_by_price":
                return commandMessages.getGroupCountingByPriceDescription();

            case "count_by_type":
                return commandMessages.getCountByTypeDescription();

            default:
                throw new NoSuchCommandException(exceptionMessages.getNoSuchCommandMsg());
        }
    }

    @Override
    public String getFieldInputMsg(String fieldName) {
        switch (fieldName) {
            case "name":
                return collectionMessages.getInputNameMsg();

            case "coordinatesX":
                return collectionMessages.getInputCoordinatesXMsg();

            case "coordinatesY":
                return collectionMessages.getInputCoordinatesYMsg();

            case "price":
                return collectionMessages.getInputPriceMsg();

            case "ticketType":
                return collectionMessages.getInputTicketTypeMsg();

            case "venueName":
                return collectionMessages.getInputVenueNameMsg();

            case "venueCapacity":
                return collectionMessages.getInputVenueCapacityMsg();

            default:
                throw new NoSuchFieldException(exceptionMessages.getNoSuchFieldMsg());
        }
    }

    @Override
    public String getCollectionTypeMsg() {
        return collectionMessages.getCollectionTypeMsg();
    }

    @Override
    public String getCollectionInitDateMsg() {
        return collectionMessages.getCollectionInitDateMsg();
    }

    @Override
    public String getCollectionSizeMsg() {
        return collectionMessages.getCollectionSizeMsg();
    }

    @Override
    public String getTicketString(Ticket ticket) {
        return collectionMessages.getTicketString(ticket);
    }
}

