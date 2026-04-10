package server;

import interfaces.IWhiteboard;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {
    public static void main(String[] args) {
        try {
            IWhiteboard board;
            if (args.length > 0) {
                board = new Whiteboard(Integer.parseInt(args[0]));
            } else {
                board = new Whiteboard();
            }
            String objName = "rmi://localhost/Board";

            System.out.println("Registering the object on RMIRegistry...");
            LocateRegistry.createRegistry(1099);
            Naming.rebind(objName, board);

            System.out.println("Waiting clients!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
