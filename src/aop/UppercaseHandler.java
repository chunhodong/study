package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 부가기능 클래스
 * */
public class UppercaseHandler implements InvocationHandler {
    Hello target;

    public UppercaseHandler(Hello target){
        this.target = target;
    }
    /**
     * 다이나믹프록시 클래스가 받은 모든요청을 리플렉션 정보로 변환
     * 변환된 정보를 invoke메소드로 전달,invoke메소드에서 모든 타깃클래스의 요청을 처리
     * 이전에 클래스로 구현된 HelloUppercase에선 인터페이스 메소드가 추가되면 코드를 수정해야됨
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String ret = (String) method.invoke(target,args);
        return ret.toUpperCase();
    }

    public static void main(String[]args){
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler(new HelloTarget())
        );
    }
}
