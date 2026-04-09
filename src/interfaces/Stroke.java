package interfaces;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Stroke implements Serializable {
    private Color color;
    private int thickness;
    private List<Point> points = new ArrayList<>();

    public Stroke(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }

    public void addPoint(int x, int y) {
        this.points.add(new Point(x, y));
    }

    public Color getColor() {
        return color;
    }

    public int getThickness() {
        return thickness;
    }

    public List<Point> getPoints() {
        return points;
    }
}
