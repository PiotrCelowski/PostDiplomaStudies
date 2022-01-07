import javax.swing.*;
import java.awt.*;

public class Painter extends JPanel {

    protected class Rectangle {
        private int x;
        private int y;
        private int sideLenght;
        private int heightLength;

        public Rectangle(int x, int y, int sideLength, int heightLength) {
            this.x = x;
            this.y = y;
            this.sideLenght = sideLength;
            this.heightLength = heightLength;
        }

        public void drawRectangle(Graphics painter) {
            painter.drawRect(this.x, this.y, this.sideLenght, this.heightLength);
        }
    }

    protected class Square extends Rectangle {
        private int x;
        private int y;
        private int sideLenght;

        public Square(int x, int y, int sideLength) {
            super(x, y, sideLength, sideLength);
        }
    }

    protected class Circle {
        private int x;
        private int y;
        private int radius;

        public Circle(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public void drawCircle(Graphics painter) {
            painter.drawOval(this.x, this.y, this.radius, this.radius);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); // wywołanie domyślnyc akcji z klasy bazowej
        g.drawLine(20, 80, 20, 200); // narysowanie linii
        g.drawLine(20, 200, 140, 200); // narysowanie linii

        g.setColor(Color.RED);
        g.fillOval(100, 100, 20, 40);

        g.drawString("Test", 200, 200);

        Rectangle rectangle = new Rectangle(0,0, 50, 20);
        rectangle.drawRectangle(g);

        Square square = new Square(60,30, 20);
        square.drawRectangle(g);

        Circle circle = new Circle(90,60, 10);
        circle.drawCircle(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Okienko"); // utworzenie obiektu okna
        frame.add(new Painter()); // dodanie panelu
        frame.setSize(300, 300); // rozmiar okienka
        frame.setLocationRelativeTo(null); // wyśrodkowanie do centrum ekranu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // wyświetlenie
    }
}	