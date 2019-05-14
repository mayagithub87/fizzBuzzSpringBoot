package maya.aleph.fizzbuzz.core;

import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static maya.aleph.fizzbuzz.core.FizzBuzzSpecifications.*;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzServiceTests {

    private static List<Integer> numbers;
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @BeforeClass
    public static void setUp() {
        Stream<Integer> infiniteStream = Stream.iterate(1, i -> i + 1);
        numbers = infiniteStream
                .limit(100)
                .collect(Collectors.toList());
    }

    @Test
    public void getFizzList_NumbersDivisibleBy3Given_ShouldReturnFizzList() {
        // given
        List<Integer> divisibleBy3Only = numbers.stream().filter(isFizz).collect(Collectors.toList());
        // when
        List<FizzBuzzType> fizzTypes = divisibleBy3Only.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(divisibleBy3Only.size(), fizzTypes.size());
        assertThat(fizzTypes, everyItem(is(FizzBuzzType.FIZZ)));
    }

    @Test
    public void getBuzzList_NumbersDivisibleBy5Given_ShouldReturnBuzzList() {
        // given
        List<Integer> divisibleBy5Only = numbers.stream().filter(isBuzz).collect(Collectors.toList());
        // when
        List<FizzBuzzType> buzzTypes = divisibleBy5Only.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(divisibleBy5Only.size(), buzzTypes.size());
        assertThat(buzzTypes, everyItem(is(FizzBuzzType.BUZZ)));
    }

    @Test
    public void getFizzBuzzList_NumbersDivisibleBy3And5Given_ShouldReturnFizzBuzzList() {
        // given
        List<Integer> divisibleBy3And5 = numbers.stream().filter(isFizzBuzz).collect(Collectors.toList());
        // when
        List<FizzBuzzType> fizzBuzzTypes = divisibleBy3And5.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(divisibleBy3And5.size(), fizzBuzzTypes.size());
        assertThat(fizzBuzzTypes, everyItem(is(FizzBuzzType.FIZZBUZZ)));
    }

    @Test
    public void getNotFizzBuzzList_NumbersDivisibleBy3And5Given_ShouldReturnNotFizzBuzzList() {
        // given
        List<Integer> notFizzBuzz = numbers.stream().filter(isNotFizzBuzz).collect(Collectors.toList());
        // when
        List<FizzBuzzType> notFizzBuzzTypes = notFizzBuzz.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        Assertions.assertSame(notFizzBuzz.size(), notFizzBuzzTypes.size());
        assertThat(notFizzBuzzTypes, everyItem(is(FizzBuzzType.NUMBER)));
    }

}

