package aop;

public class HelloTarget implements Hello{
    @Override
    public String sayHello(String name) {
        return "Hello"+name;
    }

    @Override
    public String sayHi(String name) {
        return "Hello"+name;
    }

    @Override
    public String sayThankYou(String name) {
        return "Hello"+name;
    }
}
