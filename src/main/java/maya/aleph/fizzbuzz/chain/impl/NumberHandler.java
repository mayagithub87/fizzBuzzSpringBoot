package maya.aleph.fizzbuzz.chain.impl;

import maya.aleph.fizzbuzz.chain.AbstractFizzBuzzHandler;
import maya.aleph.fizzbuzz.chain.IFizzBuzzEvaluator;
import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import org.springframework.stereotype.Component;

import static maya.aleph.fizzbuzz.core.FizzBuzzSpecifications.isNotFizzBuzz;

/**
 * Last handler in chain of responsability.
 */
@Component
public class NumberHandler extends AbstractFizzBuzzHandler implements IFizzBuzzEvaluator {

    @Override
    protected FizzBuzzType handleRequest(int number) {
        return evaluate(number);
    }

    @Override
    public FizzBuzzType evaluate(int number) {
        return isNotFizzBuzz.test(number) ? FizzBuzzType.NUMBER : null;
    }
}
