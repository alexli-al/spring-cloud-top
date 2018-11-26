package com.dogbro.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description CGLib代理
 * @auther dogbro
 * @date 2018-11-26 13:30
 */
public class CGLibProxy implements MethodInterceptor {

    private static  CGLibProxy instnace = new CGLibProxy();

    private CGLibProxy(){}

    public  static CGLibProxy getInstance(){
        return instnace;
    }
    public <T> T getProxy(Class <T> claszz){

        return (T) Enhancer.create(claszz, this);

    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, args);
        after();
        return null;
    }


    private void after() {

        System.out.println("do something after method say()");
    }

    private void before() {
        System.out.println("do something before method say()");
    }
}
