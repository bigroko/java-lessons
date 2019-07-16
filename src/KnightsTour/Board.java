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

    int Start() {
        Cell currentCell = startCell;
        Cell previousCell;
        ArrayList<Cell> nextCells = getNextCells(currentCell);

        while (nextCells.size() != 0) {
            int minMoves = Integer.MAX_VALUE;
            previousCell = currentCell;
            for (Cell nextCell : nextCells) {
                int moves = getNextCells(nextCell).size();
                if (moves < minMoves) {
                    minMoves = moves;
                    currentCell = nextCell;
                }
            }
            currentCell.setIsTaken(true);
            currentCell.setStep(previousCell.getStep() + 1);
            nextCells = getNextCells(currentCell);
        }

        return currentCell.getStep();
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
                    formatter.format("|%3s", board[i][j].getStep() == 0 ? "" : board[i][j].getStep());
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
                if (!board[nextRow][nextColumn].getIsTaken()) {
                    cells.add(board[nextRow][nextColumn]);
                }
            }
        }

        return cells;
    }
}
