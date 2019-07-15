package KnightsTour;

class Cell {
    private final String id;
    private final boolean isStartCell;
    private boolean isTaken;

    Cell(String id, boolean isStartCell) {
        this.id = id;
        this.isStartCell = isStartCell;
    }

    boolean getIsStartCell() {
        return isStartCell;
    }

    boolean getIsTaken() {
        return isTaken;
    }

    void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    @Override
    public String toString() {
        return isStartCell ? "  " : id;
    }
}
