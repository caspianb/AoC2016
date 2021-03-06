package aoc2016;

import util.ResourceReader;

public class Day2 {

    private static final String[] PROBLEM_INPUT = ResourceReader.readLines("aoc2016/input2.txt").toArray(String[]::new);

    private static final int[][] keypad = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    private static final Character[][] keypad2 = {
            { null, null, '1', null, null },
            { null, '2', '3', '4', null },
            { '5', '6', '7', '8', '9' },
            { null, 'A', 'B', 'C', null },
            { null, null, 'D', null, null },
    };

    public static void main(String[] args) {
        problem1();
        problem2();
    }

    public static void problem1() {
        String code = "";
        for (int i = 0; i < PROBLEM_INPUT.length; i++) {
            String line = PROBLEM_INPUT[i];
            int xPosition = 2;
            int yPosition = 2;

            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == 'U') yPosition = Math.max(yPosition - 1, 0);
                if (ch == 'D') yPosition = Math.min(yPosition + 1, 2);
                if (ch == 'L') xPosition = Math.max(xPosition - 1, 0);
                if (ch == 'R') xPosition = Math.min(xPosition + 1, 2);
            }

            code += keypad[yPosition][xPosition];
        }
        System.out.println(code);
    }

    public static void problem2() {
        String code = "";
        for (int i = 0; i < PROBLEM_INPUT.length; i++) {
            String line = PROBLEM_INPUT[i];
            int xPosition = 0;
            int yPosition = 2;

            for (int j = 0; j < line.length(); j++) {
                int newY = yPosition;
                int newX = xPosition;

                char ch = line.charAt(j);
                if (ch == 'U') newY = Math.max(yPosition - 1, 0);
                if (ch == 'D') newY = Math.min(yPosition + 1, 4);
                if (ch == 'L') newX = Math.max(xPosition - 1, 0);
                if (ch == 'R') newX = Math.min(xPosition + 1, 4);

                if (keypad2[newY][newX] != null) {
                    yPosition = newY;
                    xPosition = newX;
                }
            }

            code += keypad2[yPosition][xPosition];
        }
        System.out.println(code);
    }
}
