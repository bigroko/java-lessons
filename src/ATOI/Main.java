package ATOI;

public class Main {
    public static void main(String[] args) {
        System.out.println(atoi("-123456789"));
    }

    private static int atoi(String text) {
        int number = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(text.length() - 1 - i);
            if (c == '-') {
                number = 0 - number;
            } else {
                number += ((int) c - (int) '0') * Math.pow(10, i);
            }
        }
        return number;
    }
}
