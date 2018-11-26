package com.dogbro.service.impl;

import com.dogbro.service.Hello;

/**
 * @description
 * @auther dogbro
 * @date 2018-11-26 11:17
 */
public class HelloImpl implements Hello {
    @Override
    public void say() {
        System.out.println("say Helloos");
    }
}
