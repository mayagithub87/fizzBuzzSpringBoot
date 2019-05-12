package maya.aleph.fizzbuzz.core;

import maya.aleph.fizzbuzz.chain.AbstractFizzBuzzHandler;
import maya.aleph.fizzbuzz.chain.impl.FizzHandler;
import maya.aleph.fizzbuzz.domain.FizzBuzzType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

    AbstractFizzBuzzHandler handlerChain;

    public FizzBuzzService(
            @Autowired FizzHandler fizzHandler
    ) {
        this.handlerChain = fizzHandler;
    }

    public FizzBuzzType evalNumber(int number) {

        return handlerChain.receiveRequest(number);

    }
}
