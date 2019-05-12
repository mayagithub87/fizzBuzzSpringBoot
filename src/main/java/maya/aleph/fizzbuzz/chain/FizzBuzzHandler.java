package maya.aleph.fizzbuzz.chain;

import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import maya.aleph.fizzbuzz.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzHandler {
    public FizzBuzzType receiveNumber(int number) {
        return Utils.isFizz(number) ? FizzBuzzType.FIZZ : FizzBuzzType.NUMBER;
    }
}
