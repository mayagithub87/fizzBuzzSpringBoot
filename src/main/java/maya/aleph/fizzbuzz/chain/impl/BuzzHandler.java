package maya.aleph.fizzbuzz.chain.impl;

import maya.aleph.fizzbuzz.chain.AbstractFizzBuzzHandler;
import maya.aleph.fizzbuzz.chain.IFizzBuzzEvaluator;
import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import org.springframework.stereotype.Component;

import static maya.aleph.fizzbuzz.core.FizzBuzzSpecifications.isBuzz;

/**
 * Second handler in chain of responsability.
 */
@Component
public class BuzzHandler extends AbstractFizzBuzzHandler implements IFizzBuzzEvaluator {

    @Override
    protected FizzBuzzType handleRequest(int number) {
        return evaluate(number);
    }

    @Override
    public FizzBuzzType evaluate(int number) {
        return isBuzz.test(number) ? FizzBuzzType.BUZZ : null;
    }
}