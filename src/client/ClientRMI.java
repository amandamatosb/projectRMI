package client;

import interfaces.IWhiteboard;

import javax.swing.*;
import java.awt.*;
import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "localhost";
        String objName = "rmi://" + host + ":1099/Board";
        IWhiteboard board = (IWhiteboard) Naming.lookup(objName);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Whiteboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            WhiteboardPanel panel = new WhiteboardPanel(board);

            JToolBar toolbar = new JToolBar();
            toolbar.setFloatable(false);

            Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
            for (Color c : colors) {
                JButton btn = new JButton();
                btn.setBackground(c);
                btn.setOpaque(true);
                btn.setPreferredSize(new Dimension(24, 24));
                btn.addActionListener(e -> panel.setColor(c));
                toolbar.add(btn);
            }

            toolbar.addSeparator();
            toolbar.add(new JLabel(" Espessura: "));
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(2, 1, 20, 1));
            spinner.setMaximumSize(new Dimension(50, 24));
            spinner.addChangeListener(e -> panel.setThickness((int) spinner.getValue()));
            toolbar.add(spinner);

            frame.add(toolbar, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
