package client;

import interfaces.IWhiteboard;
import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) throws Exception {
        String objName = "rmi://localhost:1099/Board";
        IWhiteboard board = (IWhiteboard) Naming.lookup(objName);


    }
}
