package maya.aleph.fizzbuzz.core;

import java.util.function.IntPredicate;

public class FizzBuzzSpecifications {

    public static IntPredicate isFizz = number -> number % 3 == 0 && number % 5 != 0;

    public static IntPredicate isBuzz = number -> number % 3 != 0 && number % 5 == 0;

    public static IntPredicate isFizzBuzz = number -> number % 3 == 0 && number % 5 == 0;

    public static IntPredicate isNotFizzBuzz = number -> number % 3 != 0 && number % 5 != 0;

}
