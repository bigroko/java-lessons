package main.java.KnightsTour;

class BoardNotInitializedException extends Exception {
    @Override
    public String toString() {
        return "Board isn't initialized. Call initialize() at first.";
    }
}
