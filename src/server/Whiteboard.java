package server;

import interfaces.IWhiteboard;
import interfaces.Stroke;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Whiteboard extends UnicastRemoteObject implements IWhiteboard{

    public Whiteboard() throws RemoteException {}
    List<Stroke> synchronizedList = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void sendStroke(Stroke s) throws RemoteException {
        synchronizedList.add(s);
    }

    @Override
    public List<Stroke> getAllStrokes() throws RemoteException {
        return new ArrayList<>(synchronizedList);
    }
}
