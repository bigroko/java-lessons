package main.java.KnightsTour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;

class Board {
    private Cell[][] board;

    void initialize() {
        int randomRow = (int) (Math.random() * Constants.BOARD_SIZE);
        int randomColumn = (int) (Math.random() * Constants.BOARD_SIZE);
        board = new Cell[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                board[i][j] = new Cell(
                        Character.toString((char) (Constants.BOARD_START_CHAR + j)) + (Constants.BOARD_SIZE - i),
                        i,
                        j,
                        i == randomRow && j == randomColumn);
            }
        }
    }

    int start() throws BoardNotInitializedException {
        if (board == null) {
            throw new BoardNotInitializedException();
        }

        Cell currentCell = getStartCell();
        if (currentCell == null) {
            return 0;
        }
        currentCell.setIsTaken(true);
        currentCell.setStep(1);

        Cell previousCell;
        List<Cell> nextCells = getNextCells(currentCell);

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

    private Cell getStartCell() {
        if (board != null) {
            for (int i = 0; i < Constants.BOARD_SIZE; i++) {
                for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                    if (board[i][j].getIsStartCell()) {
                        return board[i][j];
                    }
                }
            }
        }

        return null;
    }

    private String print(boolean solution) {
        if (board == null) {
            return "";
        }
        StringBuilder boardString = new StringBuilder(1024);
        Formatter formatter = new Formatter(boardString);
        String delimiter = String.format(
                "+%s+\n", String.join("+", Collections.nCopies(Constants.BOARD_SIZE, "---")));
        boardString.append(delimiter);

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (solution) {
                    formatter.format("|%3s", board[i][j].getStep() == 0 ? "" : board[i][j].getStep());
                } else {
                    formatter.format("|%3s", board[i][j].getIsStartCell() ? "" : board[i][j]);
                }
            }
            boardString.append("|\n");
            boardString.append(delimiter);
        }

        return boardString.toString();
    }

    private List<Cell> getNextCells(Cell currentCell) {
        List<Cell> cells = new ArrayList<>();

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
