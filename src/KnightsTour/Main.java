package KnightsTour;

class Main {
    public static void main(String[] args) {
        System.out.println("Knight's Tour");

        Board board = new Board();
        System.out.println("Initial board:\n" + board);

        board.Start();

        System.out.println("Solution:\n" + board.toSolutionString());
    }
}
