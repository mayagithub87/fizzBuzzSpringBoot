package maya.aleph.fizzbuzz.chain.impl;

import maya.aleph.fizzbuzz.chain.AbstractFizzBuzzHandler;
import maya.aleph.fizzbuzz.chain.IFizzBuzzEvaluator;
import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import maya.aleph.fizzbuzz.utils.Utils;
import org.springframework.stereotype.Component;

/**
 * Third handler in chain of responsability.
 */
@Component
public class FizzBuzzHandler extends AbstractFizzBuzzHandler implements IFizzBuzzEvaluator {

    @Override
    protected FizzBuzzType handleRequest(int number) {
        return evaluate(number);
    }

    @Override
    public FizzBuzzType evaluate(int number) {
        return Utils.isFizzBuzz(number) ? FizzBuzzType.FIZZBUZZ : null;
    }
}