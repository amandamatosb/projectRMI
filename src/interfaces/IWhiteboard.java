package interfaces;

import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IWhiteboard extends Remote{
    void sendStroke(Stroke s) throws RemoteException;
    List<Stroke> getAllStrokes() throws RemoteException;
}
