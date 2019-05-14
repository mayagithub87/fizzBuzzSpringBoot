package maya.aleph.fizzbuzz.core;

import java.util.function.Predicate;

public class FizzBuzzSpecifications {

    public static Predicate<Integer> isFizz = number -> number % 3 == 0 && number % 5 != 0;

    public static Predicate<Integer> isBuzz = number -> number % 3 != 0 && number % 5 == 0;

    public static Predicate<Integer> isFizzBuzz = number -> number % 3 == 0 && number % 5 == 0;

    public static Predicate<Integer> isNotFizzBuzz = number -> number % 3 != 0 && number % 5 != 0;

}
