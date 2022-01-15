package game;

import java.awt.*;

public class Food extends Agent {
    int capacity = 1;
    final int MAX_CAPACITY = 5;

    public Food() {
        this.color = Color.GREEN;
        this.priority = 1;
    }

    @Override
    public void paint(Graphics2D g2d, int size) {
        g2d.setColor(this.color);
        g2d.fillRect(y*size, x*size, size, size);
        g2d.setColor(Color.BLACK);
    }

    @Override
    public void move(Board board) {
        capacity += 1;
        if(capacity > MAX_CAPACITY) {
            board.addAgent(AgentsEnum.FOOD.getAgent());
            capacity = 1;
        }
    }

    @Override
    protected boolean checkNextPosition(int x, int y, Board board) {
        return false;
    }
}
