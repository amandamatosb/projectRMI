package client;

import interfaces.IWhiteboard;
import interfaces.Stroke;

import java.awt.*;
import java.rmi.Naming;

import static java.awt.Color.blue;

public class ClientRMI {
    public static void main(String[] args) throws Exception {
        String objName = "rmi://localhost:1099/Board";
        IWhiteboard board = (IWhiteboard) Naming.lookup(objName);

        Stroke firstline = new Stroke(Color.blue, 2);
        firstline.addPoint(1,2);
        firstline.addPoint(1, 4);
        firstline.addPoint(1, 6);

        board.sendStroke(firstline);

        System.out.println("All strokes: " + board.getAllStrokes().size());

    }
}
