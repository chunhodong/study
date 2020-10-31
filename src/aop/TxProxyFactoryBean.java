package aop;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 다이나믹프록시는 클래스정보를 알수없기때문에 스프링의 빈으로 등록하지 못함
 * 팩토리빈을 이용해서 스프링빈으로 등록할 수 있음
 * 코드수정없이 여러타겟클래스에 적용할 수 있다.
 * */
public class TxProxyFactoryBean implements FactoryBean<Object> {
    Object target;
    String pattern;
    Class<?> serviceInterface;

    public void setTarget(Object target){
        this.target = target;
    }
    public void setPattern(String pattern){
        this.pattern = pattern;
    }

    public void setServiceInterface(Class<?> serviceInterface){
        this.serviceInterface = serviceInterface;
    }

    /**
     * 팩토리빈이 생성하는 오브젝트
     * */
    @Override
    public Object getObject() throws Exception {
        TransactionHandler transactionHandler = new TransactionHandler();
        transactionHandler.setTarget(target);
        transactionHandler.setPattern(pattern);
        return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{serviceInterface},transactionHandler);
        
    }


    /**
     * 팩토리빈이 생성할 빈타입
     * */
    @Override
    public Class<?> getObjectType() {
        return this.serviceInterface;
    }
}
