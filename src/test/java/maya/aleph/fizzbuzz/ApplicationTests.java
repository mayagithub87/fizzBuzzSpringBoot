package maya.aleph.fizzbuzz;

import maya.aleph.fizzbuzz.core.FizzBuzzService;
import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import maya.aleph.fizzbuzz.utils.Utils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

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
        List<Integer> divisibleBy3Only = numbers.stream().filter(Utils::isFizz).collect(Collectors.toList());
        // when
        List<FizzBuzzType> fizzTypes = divisibleBy3Only.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        assertSame(divisibleBy3Only.size(), fizzTypes.size());
        assertThat(fizzTypes, everyItem(is(FizzBuzzType.FIZZ)));
    }

    @Test
    public void getBuzzList_NumbersDivisibleBy5Given_ShouldReturnBuzzList() {
        // given
        List<Integer> divisibleBy5Only = numbers.stream().filter(Utils::isBuzz).collect(Collectors.toList());
        // when
        List<FizzBuzzType> fizzTypes = divisibleBy5Only.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        assertSame(divisibleBy5Only.size(), fizzTypes.size());
        assertThat(fizzTypes, everyItem(is(FizzBuzzType.BUZZ)));
    }

    @Test
    public void getFizzBuzzList_NumbersDivisibleBy3And5Given_ShouldReturnFizzBuzzList() {
        // given
        List<Integer> divisibleBy3And5 = numbers.stream().filter(Utils::isFizzBuzz).collect(Collectors.toList());
        // when
        List<FizzBuzzType> fizzTypes = divisibleBy3And5.stream()
                .map(fizzBuzzService::evalNumber)
                .collect(Collectors.toList());
        //then
        assertSame(divisibleBy3And5.size(), fizzTypes.size());
        assertThat(fizzTypes, everyItem(is(FizzBuzzType.FIZZBUZZ)));
    }

}
