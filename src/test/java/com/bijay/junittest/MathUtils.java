package com.bijay.junittest;

import org.springframework.stereotype.Component;

@Component
public  class MathUtils {

    public  int add(int a, int b) {
        return a + b;
    }
    public  int substact(int a, int b) {
        return a - b;
    }
}