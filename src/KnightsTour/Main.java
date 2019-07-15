package KnightsTour;

class Main {
    public static void main(String[] args) {
        System.out.println("Knight's Tour (Warnsdorff's rule)\n");

        int boardSize = 8;
        char startChar = 'a';
        int randomRow = (int) (Math.random() * boardSize);
        int randomColumn = (int) (Math.random() * boardSize);
        Cell[][] board = new Cell[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new Cell(Character.toString(startChar + j) + (boardSize - i),
                        i == randomRow & j == randomColumn);
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
