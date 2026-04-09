package server;

import interfaces.IWhiteboard;
import interfaces.Stroke;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;

public class Whiteboard extends UnicastRemoteObject implements IWhiteboard{

    public Whiteboard() throws RemoteException {}

    @Override
    public void sendStroke(Stroke s) throws RemoteException {

    }

    @Override
    public List<Stroke> getAllStrokes() throws RemoteException {
        return List.of();
    }
}
