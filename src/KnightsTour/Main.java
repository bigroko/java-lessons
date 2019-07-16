package KnightsTour;

class Main {
    public static void main(String[] args) {
        System.out.println("Knight's Tour");

        Board board = new Board();
        System.out.println("Initial board:\n" + board);

        int steps = board.Start();

        System.out.println("Solution (" + steps + " steps):\n" + board.toSolutionString());
    }
}
