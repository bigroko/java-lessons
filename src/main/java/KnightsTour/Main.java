package main.java.KnightsTour;

class Main {
    public static void main(String[] args) {
        System.out.println("Knight's Tour");
        try {
            Board board = new Board();
            board.initialize();
            System.out.println("Initial board:\n" + board);
            System.out.println("Solution (" + board.start() + " steps):\n" + board.toSolutionString());
        } catch (BoardNotInitializedException e) {
            e.printStackTrace();
        }
    }
}
