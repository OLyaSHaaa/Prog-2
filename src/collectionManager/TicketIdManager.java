package collectionManager;

import java.util.HashSet;
import java.util.Set;

/**
 * Реализация интерфейса IdManager
 */
public class TicketIdManager implements IdManager<Long>{
    private Set<Long> usedIdentifiers;
    private static TicketIdManager instance;

    /**
     * @return объект TicketIdManager
     */
    public synchronized static TicketIdManager getInstance(){
        if (instance == null){
            instance = new TicketIdManager();
        }
        return instance;
    }

    private TicketIdManager(){
        usedIdentifiers = new HashSet<Long>();
    }

    @Override
    public boolean idIsFree(Long id) {
        return !usedIdentifiers.contains(id);
    }

    @Override
    public Long getFreeId() {
        Long prevId = 0L;
        for (Long id: usedIdentifiers) {
            if (id - prevId != 1) {
                break;
            }
            prevId = id;
        }
        return prevId + 1;
    }

    @Override
    public void addId(Long id) {
        usedIdentifiers.add(id);
    }

    @Override
    public void removeId(Long id) {
        usedIdentifiers.remove(id);
    }

    @Override
    public void clearIdentifiers() {
        usedIdentifiers.clear();
    }
}
