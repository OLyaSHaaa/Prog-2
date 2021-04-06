package commands;

import collectionManager.CollectionManager;
import output.OutputManager;
import ticket.Ticket;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class GroupCountingByPriceCommand implements Command{
    private CollectionManager collectionManager;
    private OutputManager outputManager;

    public GroupCountingByPriceCommand(CollectionManager collectionManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
    }

    @Override
    public void execute() {
//        Stream<Ticket> stream = collectionManager.getTicketsStream()
//                .sorted((t1, t2) -> (int) (t1.getPrice() - t2.getPrice()));
//        while (stream.count() > 0){
//            long price = stream.findFirst().get().getPrice();
//            outputManager.printMsg(price + ": " + stream.filter(ticket -> ticket.getPrice() == price).count() + "\n");
//            stream = stream.filter(ticket -> ticket.getPrice() != price);
//        }
        Set<Long> prices = new HashSet<>();
        collectionManager.getTicketsStream().forEach(ticket -> prices.add(ticket.getPrice()));
        for (long price: prices){
            outputManager.printMsg(price + ": " +
                    collectionManager.getTicketsStream()
                            .filter(ticket -> ticket.getPrice() == price)
                            .count() + "\n");
        }
    }
}
