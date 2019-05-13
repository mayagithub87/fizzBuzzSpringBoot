package maya.aleph.fizzbuzz.utils;

import maya.aleph.fizzbuzz.domain.FizzBuzzType;

public class Utils {

    public static boolean isFizz(int number) {
        return (number % 3 == 0 && number % 5 != 0);
    }

    public static boolean isBuzz(int number) {
        return (number % 3 != 0 && number % 5 == 0);
    }

    public static boolean isFizzBuzz(int number) {
        return (number % 3 == 0 && number % 5 == 0);
    }

    public static boolean isNotFizzBuzz(int number) {
        return (number % 3 != 0 && number % 5 != 0);
    }

    public static boolean isLineNeeded(String line) {
        return line.matches("\\s*(\\d{1,3}):\\s(fizz|buzz|fizzbuzz|\\d{1,3})");
    }

    public static void printLine(int number, FizzBuzzType fizzBuzzType) {
        if (!fizzBuzzType.equals(FizzBuzzType.NUMBER))
            System.out.println(String.format("%3d: %s", number, fizzBuzzType.toString()));
        else
            System.out.println(String.format("%3d: %d", number, number));

    }
}
