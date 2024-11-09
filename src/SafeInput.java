import java.util.*;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        String trash = "";
        boolean status = false;
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space

            if (pipe.hasNextInt()) {
                status = true;
                retInt = pipe.nextInt();
            } else {
                trash = pipe.nextLine();
            }

        } while (!status);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        String trash = "";
        boolean status = false;
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space

            if (pipe.hasNextDouble()) {
                status = true;
                retDouble = pipe.nextDouble();
            } else {
                trash = pipe.nextLine();
            }

        } while (!status);

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println(prompt + "[" + low + "-" + high + "]:");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                if (result >= low && result <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value in range [" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int [" + low + "-" + high + "]");
            }
        } while (!done);

        return result;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println(prompt + "[" + low + "-" + high + "]:");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();
                if (result >= low && result <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value in range [" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a Double [" + low + "-" + high + "]");
            }
        } while (!done);
        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean result = false;
        boolean done = false;
        String trash = "";
        String ans = "";

        do {
            System.out.print(prompt + " (Y/N): ");  // Adjust prompt for clarity
            ans = pipe.nextLine().trim();  // Use trim to remove leading/trailing spaces

            if (ans.equalsIgnoreCase("y")) {
                result = true;
                done = true;
            } else if (ans.equalsIgnoreCase("n")) {
                result = false;
                done = true;
            } else {
                System.out.println("You must enter Y or N...");
            }
        } while (!done);

        return result;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input = "";
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();

            if (input.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!valid);

        return input;
    }

    public static void prettyHeader(String msg) {
        final int LINE_WIDTH = 60;
        int msgLength = msg.length();

        int totalPadding = LINE_WIDTH - msgLength - 6;
        int paddingLeft = totalPadding / 2;
        int paddingRight = totalPadding - paddingLeft;

        for (int i = 0; i < LINE_WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");
        for (int i = 0; i < paddingLeft; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < paddingRight; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < LINE_WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}