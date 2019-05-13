package maya.aleph.fizzbuzz;

import maya.aleph.fizzbuzz.core.FizzBuzzService;
import maya.aleph.fizzbuzz.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("START");

        IntStream.range(1, 101).forEach(i -> Utils.printLine(i, fizzBuzzService.evalNumber(i)));

        System.out.println("END");

    }
}