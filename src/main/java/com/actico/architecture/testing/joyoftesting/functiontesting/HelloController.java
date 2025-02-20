package com.actico.architecture.testing.joyoftesting.functiontesting;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HelloController {

    public static String getHello(String name) {
        return "Hello" + name;
    }
}
