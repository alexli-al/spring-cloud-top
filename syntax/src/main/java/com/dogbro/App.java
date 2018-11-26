package com.dogbro;

import com.dogbro.proxy.CGLibProxy;
import com.dogbro.proxy.DynamicHelloProxy;
import com.dogbro.proxy.HelloProxy;
import com.dogbro.service.Hello;
import com.dogbro.service.impl.HelloImpl;

import java.lang.reflect.Proxy;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-26 11:15
 */
public class App {

    public static  void main(String[] args){

        //初始调用
//        Hello hello = new HelloImpl();
//        hello.say();

        //静态代理
//        HelloProxy proxy = new HelloProxy();
//        proxy.say();

//        Hello hello = new HelloImpl();
//        DynamicHelloProxy dynamicProxy = new DynamicHelloProxy(hello);
//        Hello dynamicHelloProxy =(Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(),
//                hello.getClass().getInterfaces(),
//                dynamicProxy);
//        dynamicHelloProxy.say();

        //jdk动态代理
//        DynamicHelloProxy dynamicProxy = new DynamicHelloProxy(new HelloImpl());
//        Hello dynamicHelloProxy =  dynamicProxy.getProxy();
//        dynamicHelloProxy.say();

            //CGLibe代理
//        CGLibProxy cgLibProxy = new CGLibProxy();
//        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
//        helloProxy.say();

        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say();

    }
}
