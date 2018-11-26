package com.dogbro.proxy;

import com.dogbro.service.Hello;
import com.dogbro.service.impl.HelloImpl;

/**
 * @description Hello的静态代理类
 * @auther dogbro
 * @date 2018-11-26 11:20
 */
public class HelloProxy implements Hello {

    private  Hello hello;

    public HelloProxy(){
        this.hello = new HelloImpl();
    }

    @Override
    public void say() {
        before();
        hello.say();
        after();
    }

    private void after() {

        System.out.println("do something after method say()");
    }

    private void before() {
        System.out.println("do something before method say()");
    }
}
