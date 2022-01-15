package game;

public class Game {
    private final int rows;
    private final int columns;
    private final Board board;

    public Game(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new Board(rows, columns);
    }

    public void display() {
        board.display();
    }

    public static void main(String[] args) {
        Game game = new Game(20, 40);
        game.addAgent(AgentsEnum.RABBIT);
        game.addAgent(AgentsEnum.RABBIT);
        for(int i=0; i<5; i++) {
            game.addAgent(AgentsEnum.FOOD);
        }
        game.display();

    }

    private void addAgent(AgentsEnum agent) {
        this.board.addAgent(agent.getAgent());
    }
}
