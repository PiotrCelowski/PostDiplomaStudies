package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board extends JPanel {
    private final Field[][] board;
    private final int width;
    private final int height;
    private final int size = 40;
    private List<Agent> agents;


    public Board(int rows, int columns) {
        board = new Field[rows][columns];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = new Field(i,j);
            }
        }

        this.height = rows * this.size + 100;
        this.width = columns * this.size + 50;

        this.agents = new ArrayList<>();
    }

    public Field get(int x, int y) {
        return board[x][y];
    }

    public void display() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setSize(this.width, this.height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j].paint(g2d, size);
            }
        }

        for(Agent agent : agents) {
            agent.paint(g2d, size);
        }
    }

    public void addAgent(Agent agent) {
        int y = new Random().nextInt(this.board[0].length);
        int x = new Random().nextInt(this.board.length);
        agent.setPosition(x, y);
        this.agents.add(agent);
    }
}
