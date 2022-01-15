package game;

import java.awt.*;

public class Field {
    private final int x,y;
    private boolean active = false;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Field {" + "x=" + this.x + ", y=" + this.y + "}";
    }

    public void paint(Graphics2D g2d, int size) {
        if (this.active) {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(this.y * size, this.x * size, size, size);
            g2d.setColor(Color.BLACK);
        } else {
            g2d.drawRect(this.y * size, this.x * size, size, size);
        }
    }

    public void setActive() {
        this.active = true;
    }

    public void setInactive() {
        this.active = false;
    }
}
