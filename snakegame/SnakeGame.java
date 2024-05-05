package snakegame;

import java.util.*;

public class SnakeGame {
    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final char EMPTY_CELL = '.';
    public static final char SNAKE_BODY = '0';
    public static final char FOOD = '*';

    private char[][] board;
    private List<int[]> snake;
    private Random random;
    private int[] foodPosition;

    private Direction direction;

    public SnakeGame() {
        board = new char[ROWS][COLS];
        snake = new LinkedList<>();
        random = new Random();
        direction = Direction.RIGHT; // Initial direction
        initBoard();
        initSnake();
        placeFood();
    }

    private void initBoard() {
        for (int i = 0; i < ROWS; i++) {
            Arrays.fill(board[i], EMPTY_CELL);
        }
    }

    private void initSnake() {
        int[] head = {ROWS / 2, COLS / 2}; // Start the snake in the middle of the board
        snake.add(head);
        board[head[0]][head[1]] = 'H';
    }

    private void placeFood() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the food place (row and col)");
        int row, col;
        do {
            row =sc.nextInt();
            col =sc.nextInt();
            if(board[row][col] != EMPTY_CELL)
                System.out.println("The position you have entered is the same position the snake head");
        } while (board[row][col] != EMPTY_CELL);
        foodPosition = new int[]{row, col};
        board[row][col] = FOOD;
    }

    public void move() {
        int[] head = Arrays.copyOf(snake.get(0), 2);
        board[head[0]][head[1]] = '0';
        switch (direction) {
            case UP:
                head[0]--;
                break;
            case DOWN:
                head[0]++;
                break;
            case LEFT:
                head[1]--;
                break;
            case RIGHT:
                head[1]++;
                break;
        }

        if (head[0] < 0 || head[0] >= ROWS || head[1] < 0 || head[1] >= COLS ||
                board[head[0]][head[1]] == SNAKE_BODY) {
            System.out.println("Game Over!");
            System.exit(0);
        }

        snake.add(0,head);
        int[] tail1 = snake.get(snake.size()-1);
        board[tail1[0]][tail1[1]] = 'T';

        if (Arrays.equals(head, foodPosition)) {
            // Snake catches the food
            placeFood();
        } else {
            int[] tail = snake.remove(snake.size()-1);
//            System.out.println(Arrays.toString(tail1));
            board[tail[0]][tail[1]] = EMPTY_CELL;
//            board[tail[0]][tail[1]] = 'T';
        }
        board[head[0]][head[1]] = 'H';
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.printBoard();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter direction (L/R/U/D): ");
            String input = scanner.nextLine().toUpperCase();
            Direction direction;
            switch (input) {
                case "L":
                    direction = Direction.LEFT;
                    break;
                case "R":
                    direction = Direction.RIGHT;
                    break;
                case "U":
                    direction = Direction.UP;
                    break;
                case "D":
                    direction = Direction.DOWN;
                    break;
                default:
                    direction = null;
            }
            if (direction != null) {
                game.setDirection(direction);
                game.move();
                game.printBoard();
            } else {
                System.out.println("Invalid direction! Please enter L/R/U/D.");
            }
        }
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}