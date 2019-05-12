package maya.aleph.fizzbuzz.utils;

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

}
