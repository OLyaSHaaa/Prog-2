package collectionManager;

public interface IdManager<T> {

    /**
     * Метод, который проверяет, свободен ли id
     * @param id значение id
     * @return true, если свободен, false, если занят
     */
    boolean idIsFree(T id);

    /**
     * @return первый свободный идентификатор
     */
    T getFreeId();

    /**
     * Метод, который добавляет идентификатор в использованные
     * @param id идентификатор
     */
    void addId(T id);

    /**
     * Метод, который удаляет идентификатор из использованных
     * @param id идентификатор
     */
    void removeId(T id);

    /**
     * Метод, который удаляет все использованные идентификаторы
     */
    void clearIdentifiers();
}

