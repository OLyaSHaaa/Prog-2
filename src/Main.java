//import dataManager.JSONTicketReader;
//import exceptions.BrokenDataException;
//import exceptions.InvalidFieldException;
//import exceptions.NoDataException;
//import exceptions.NoEnvVarException;
//
//public class Main {
//    public static void main(String[] args){
//        JSONTicketReader ticketReader = new JSONTicketReader("data.json");
//        try {
//            ticketReader.readElements(messenger);
//        } catch (InvalidFieldException e) {
//            e.printStackTrace();
//        } catch (NoEnvVarException e) {
//            e.printStackTrace();
//        } catch (NoDataException e) {
//            e.printStackTrace();
//        } catch (BrokenDataException e) {
//            e.printStackTrace();
//        }
//    }
//}

import application.Application;
import application.ApplicationImpl;

public class Main {
    public static void main(String[] args){
        Application app = new ApplicationImpl();
        app.start();
    }
}