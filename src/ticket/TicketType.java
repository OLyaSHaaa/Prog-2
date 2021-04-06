package ticket;

/**
 * Перречисление типов билетов
 */
public enum TicketType{
    VIP(3),
    USUAL(2),
    BUDGETARY(1),
    CHEAP(0);

    private int typeCode;

    TicketType(int typeCode){
        this.typeCode = typeCode;
    }

    public int getTypeCode(){
        return typeCode;
    }
}
