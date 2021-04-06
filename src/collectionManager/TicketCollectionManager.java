package collectionManager;

import exceptions.*;
import dataManager.DataManager;
import ticket.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/**
 * Реализация интерфейса CollectionManager
 */
public class TicketCollectionManager implements CollectionManager {
    private final LocalDate initDate;
    private HashSet<Ticket> ticketHashSet;
    private DataManager dataManager;

    /**
     * @param dataManager менеджер данных коллекции
     */
    public TicketCollectionManager(DataManager dataManager) {
        initDate = LocalDate.now();
        ticketHashSet = new HashSet<>();
        this.dataManager = dataManager;
    }

    @Override
    public Class getType() {
        return ticketHashSet.getClass();
    }

    @Override
    public int getSize() {
        return ticketHashSet.size();
    }

    @Override
    public LocalDate getInitDate() {
        return initDate;
    }

    @Override
    public void addElement(Ticket ticket) {
        ticketHashSet.add(ticket);
    }

    @Override
    public boolean removeElement(Long id) {
        for (Ticket ticket : ticketHashSet) {
            if (ticket.getId() == id) {
                TicketIdManager.getInstance().removeId(id);
                ticketHashSet.remove(ticket);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        TicketIdManager.getInstance().clearIdentifiers();
        ticketHashSet.clear();
    }

    @Override
    public void loadTickets() throws NoEnvVarException, InvalidFieldException, NoDataException, BrokenDataException {
        ticketHashSet.addAll(dataManager.readElements());
    }

    @Override
    public void saveTickets() {
        dataManager.writeElements(ticketHashSet);
    }

    @Override
    public Stream<Ticket> getTicketsStream() {
        return ticketHashSet.stream();
    }
}