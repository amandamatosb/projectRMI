package client;

import interfaces.IWhiteboard;
import interfaces.Stroke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class WhiteboardPanel extends JPanel {
    private final IWhiteboard board;
    private List<Stroke> strokes = new ArrayList<>();
    private Stroke currentStroke;
    private Color color = Color.BLACK;
    private int thickness = 2;

    public WhiteboardPanel(IWhiteboard board) {
        this.board = board;
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentStroke = new Stroke(color, thickness);
                currentStroke.addPoint(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentStroke != null) {
                    try {
                        board.sendStroke(currentStroke);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    currentStroke = null;
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentStroke != null) {
                    currentStroke.addPoint(e.getX(), e.getY());
                    repaint();
                }
            }
        });

        new Timer(500, e -> {
            try {
                strokes = board.getAllStrokes();
                repaint();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public void setColor(Color color) { this.color = color; }
    public void setThickness(int thickness) { this.thickness = thickness; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Stroke s : strokes) {
            drawStroke(g2, s);
        }
        if (currentStroke != null) {
            drawStroke(g2, currentStroke);
        }
    }

    private void drawStroke(Graphics2D g2, Stroke s) {
        g2.setColor(s.getColor());
        g2.setStroke(new BasicStroke(s.getThickness(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        List<Point> points = s.getPoints();
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}
