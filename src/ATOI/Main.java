package ATOI;

class Main {
    public static void main(String[] args) {
        String textNumber = "-123 456 789";
        System.out.println(atoi(textNumber));
    }

    private static int atoi(String text) {
        int number = 0;
        int exponent = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(text.length() - 1 - i);
            if (c == '-') {
                number = 0 - number;
            } else if (Character.isDigit(c)) {
                number += ((int) c - (int) '0') * Math.pow(10, exponent);
                exponent++;
            }
        }
        return number;
    }
}
