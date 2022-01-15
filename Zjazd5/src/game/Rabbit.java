package game;

import java.awt.*;
import java.util.Random;

public class Rabbit extends Agent {

    public Rabbit() {
        this.color = Color.RED;
        this.priority = 10;
    }

    @Override
    public void paint(Graphics2D g2d, int size) {
        g2d.setColor(this.color);
        g2d.fillOval(y*size, x*size, size, size);
        g2d.setColor(Color.BLACK);
    }

    @Override
    public void move(Board board) {
        int cx = new Random().nextInt(2);
        int cy = new Random().nextInt(2);
        this.checkNextPosition(this.x + cx, this.y + cy, board);
        this.setPosition(this.x + cx, this.y + cy);
        System.out.println(this.x + ", " + this.y);
    }

    @Override
    protected boolean checkNextPosition(int x, int y, Board board) {
        return true;
    }
}
