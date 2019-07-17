package main.java.KnightsTour;

class Cell {
    private final String id;
    private final int row;
    private final int column;
    private final boolean isStartCell;
    private int step;
    private boolean isTaken;

    Cell(String id, int row, int column, boolean isStartCell) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.isStartCell = isStartCell;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    boolean getIsStartCell() {
        return isStartCell;
    }

    int getStep() {
        return step;
    }

    void setStep(int step) {
        this.step = step;
    }

    boolean getIsTaken() {
        return isTaken;
    }

    void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    @Override
    public String toString() {
        return id;
    }
}
