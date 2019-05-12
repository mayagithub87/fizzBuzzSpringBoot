package maya.aleph.fizzbuzz.chain;

import maya.aleph.fizzbuzz.domain.FizzBuzzType;

public abstract class AbstractFizzBuzzHandler {

    protected AbstractFizzBuzzHandler nextHandler;

    public FizzBuzzType receiveRequest(int number) {
        FizzBuzzType fizzBuzzType = handleRequest(number);
        return (fizzBuzzType != null) ? fizzBuzzType : nextHandler.receiveRequest(number);
    }

    abstract protected FizzBuzzType handleRequest(int number);

}
