package server;

import interfaces.IWhiteboard;
import interfaces.NgrokClientSocketFactory;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {
    public static void main(String[] args) {
        try {
            System.out.println("Registering the object on RMIRegistry...");

            IWhiteboard board;
            if (args.length > 0) {
                int ngrokPort = Integer.parseInt(args[0]);
                NgrokClientSocketFactory csf = new NgrokClientSocketFactory(ngrokPort);
                LocateRegistry.createRegistry(1099, csf, null);
                board = new Whiteboard(ngrokPort);
            } else {
                LocateRegistry.createRegistry(1099);
                board = new Whiteboard();
            }

            Naming.rebind("rmi://localhost/Board", board);
            System.out.println("Waiting clients!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
