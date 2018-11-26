package com.dogbro.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description Hello动态代理
 * @auther dogbro
 * @date 2018-11-26 11:24
 */
public class DynamicHelloProxy implements InvocationHandler {

    private  Object target;

    public  DynamicHelloProxy(Object target){
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public  <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void after() {

        System.out.println("do something after method say()");
    }

    private void before() {
        System.out.println("do something before method say()");
    }
}
