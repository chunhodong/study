package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {
    private Object target;
    private String pattern;

    public void setTarget(Object target){
        this.target = target;
    }
    public void setPattern(String pattern){
        this.pattern = pattern;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith(pattern)){
            return invokeTransaction(method,args);
        }else{
            return method.invoke(target,args);

        }
    }
    public Object invokeTransaction(Method method,Object[]args){

        try {
            return method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
