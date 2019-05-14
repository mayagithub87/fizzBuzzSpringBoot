package maya.aleph.fizzbuzz;

import maya.aleph.fizzbuzz.core.FizzBuzzService;
import maya.aleph.fizzbuzz.utils.ConsoleOutputUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private FizzBuzzService fizzBuzzService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        logger.info("START");

        IntStream.range(1, 101).forEach(i -> ConsoleOutputUtils.printLine(i, fizzBuzzService.evalNumber(i)));

        logger.info("END");

    }
}