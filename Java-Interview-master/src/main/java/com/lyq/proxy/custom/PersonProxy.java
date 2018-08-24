package com.lyq.proxy.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author liangyanqun
 * @description 自定义代理
 * @date 2018-08-24 16:55
 */
public class PersonProxy  implements GPInvocationHandler{
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonProxy.class);
    private Person target;

    public Object getInstance(Object target){
        System.out.println("=======start getInstance=====");
        this.target = (Person) target;
        Class<? extends Object> clazz = target.getClass();


        return GPPorxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(target,args);
        after();
        LOGGER.info("proxy class={}", proxy.getClass());
        return null;
    }

    private void before() {
        LOGGER.info("handle before");
    }

    private void after() {
        LOGGER.info("handle after");
    }

}
