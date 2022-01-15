package game;

import java.awt.*;

public abstract class Agent implements Comparable<Agent> {
    protected int priority;
    private boolean isAlive = true;
    protected int x,y;
    protected Color color;

    public Agent() {
    }

    public abstract void paint(Graphics2D g2d, int size);

    public abstract void move(Board board);

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected abstract boolean checkNextPosition(int x, int y, Board board);

    @Override
    public int compareTo(Agent agent) {
        return this.priority - agent.priority;
    }
}
