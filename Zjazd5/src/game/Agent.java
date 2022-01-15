package game;

import java.awt.*;

public abstract class Agent {
    private boolean isAlive = true;
    protected int x,y;
    protected Color color;

    public Agent() {
    }

    public abstract void paint(Graphics2D g2d, int size);

    public abstract void move();

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
