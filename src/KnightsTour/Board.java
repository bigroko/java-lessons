package KnightsTour;

import java.util.ArrayList;
import java.util.Formatter;

class Board {
    private final Cell[][] board;
    private Cell startCell;

    Board() {
        int randomRow = (int) (Math.random() * Constants.BOARD_SIZE);
        int randomColumn = (int) (Math.random() * Constants.BOARD_SIZE);
        board = new Cell[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                board[i][j] = new Cell(
                        Character.toString(Constants.BOARD_START_CHAR + j) + (Constants.BOARD_SIZE - i),
                        i,
                        j,
                        i == randomRow && j == randomColumn);
                if (board[i][j].getIsStartCell()) {
                    startCell = board[i][j];
                    startCell.setIsTaken(true);
                    startCell.setStep(1);
                }
            }
        }
    }

    void Start() {
        System.out.println(getNextCells(startCell));
    }

    @Override
    public String toString() {
        return print(false);
    }

    String toSolutionString() {
        return print(true);
    }

    private String print(boolean solution) {
        StringBuilder boardString = new StringBuilder(512);
        Formatter formatter = new Formatter(boardString);
        StringBuilder delimiter = new StringBuilder(128);

        delimiter.append("+---".repeat(Constants.BOARD_SIZE));
        delimiter.append("+\n");
        boardString.append(delimiter);

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (solution) {
                    formatter.format("|%3d", board[i][j].getStep());
                } else {
                    formatter.format("|%3s", board[i][j]);
                }
            }
            boardString.append("|\n");
            boardString.append(delimiter);
        }

        return boardString.toString();
    }

    private ArrayList<Cell> getNextCells(Cell currentCell) {
        ArrayList<Cell> cells = new ArrayList<>();

        for (int[] delta : Constants.KNIGHT_MOVE_PATTERN) {
            int nextRow = currentCell.getRow() + delta[0];
            int nextColumn = currentCell.getColumn() + delta[1];
            if ((nextRow >= 0 && nextRow < Constants.BOARD_SIZE) &&
                    (nextColumn >= 0 && nextColumn < Constants.BOARD_SIZE)) {
                Cell nextCell = board[nextRow][nextColumn];
                if (!nextCell.getIsTaken()) {
                    cells.add(nextCell);
                }
            }
        }

        return cells;
    }
}
