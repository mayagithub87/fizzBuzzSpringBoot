package maya.aleph.fizzbuzz.utils;

import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleOutputUtils {

    static Logger logger = LoggerFactory.getLogger(ConsoleOutputUtils.class);

    private ConsoleOutputUtils() {
    }

    public static boolean isLineNeeded(String line) {
        return line.matches("\\s*(\\d{1,3}):\\s(fizz|buzz|fizzbuzz|\\d{1,3})");
    }

    public static void printLine(int number, FizzBuzzType fizzBuzzType) {
        logger.info("{}: {}", number, !fizzBuzzType.equals(FizzBuzzType.NUMBER) ? fizzBuzzType.toString() : number);
    }
}
