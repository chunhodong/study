package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.framework.ProxyFactoryBean;


/**
 * TxProxyFactoryBean의 경우
 * 한 타깃에 여러 부가기능을 적용하기위해선
 * 부가기능마다 팩토리빈설정이 추가된다, 추가로 빈마다 부가기능 오브젝트를 생성해야되기떄문에
 * 동일한 부가기능 코드가 중복될수 있음
 *
 * */
public class HelloProxyFactoryBean {
    public static void main(String[]args)  {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(new HelloTarget());
       // proxyFactoryBean.addAdvice(new UpperCaseAdvice());

    }

    static class UpperCaseAdvice implements MethodInterceptor{

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            return methodInvocation.proceed();
        }
    }
}

