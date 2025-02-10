package com.actico.architecture.testing.joyoftesting;

import org.springframework.boot.SpringApplication;

public class TestJoyOfTestingApplication {

    public static void main(String[] args) {
        SpringApplication.from(JoyOfTestingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
