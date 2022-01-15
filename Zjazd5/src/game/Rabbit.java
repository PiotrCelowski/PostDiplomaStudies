package game;

import java.awt.*;

public class Rabbit extends Agent {

    public Rabbit() {
        this.color = Color.RED;
    }

    @Override
    public void paint(Graphics2D g2d, int size) {
        g2d.setColor(this.color);
        g2d.fillOval(y*size, x*size, size, size);
        g2d.setColor(Color.BLACK);
    }

    @Override
    public void move() {

    }
}
