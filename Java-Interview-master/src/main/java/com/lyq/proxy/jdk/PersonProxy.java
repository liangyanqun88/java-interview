package com.lyq.proxy.jdk;

import com.crossoverjie.proxy.jdk.CustomizeHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonProxy implements InvocationHandler {
	private final static Logger LOGGER = LoggerFactory.getLogger(PersonProxy.class);
	private Person target;
	
	public Object getInstance(Object target){
		System.out.println("=======开始实例化代理对象");
		this.target = (Person)target;
		Class<? extends Object> clazz = target.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
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
