import javax.swing.*;
import java.awt.*;

public class Painter extends JPanel {

    protected class Square {
        private int x;
        private int y;
        private int sideLenght;

        public Square(int x, int y, int sideLength) {
            this.x = x;
            this.y = y;
            this.sideLenght = sideLength;
        }

        public void drawSquare(Graphics painter) {

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