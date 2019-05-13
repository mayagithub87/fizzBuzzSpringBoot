package maya.aleph.fizzbuzz;

import maya.aleph.fizzbuzz.core.FizzBuzzServiceTests;
import maya.aleph.fizzbuzz.main.ApplicationTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        FizzBuzzServiceTests.class, ApplicationTests.class
})
public class AllTests {
}
