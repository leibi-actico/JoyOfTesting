package com.actico.architecture.testing.joyoftesting.exceptions;

public class SomeService {

    public String getSomeServiceMessage() {
        var someInterface = new SomeInterfaceImpl();
        try {
            return "Some Service Message with " + someInterface.getName();
        } catch (Exception e) {
            return "Some Service Message with unknown name";
        }
    }

}
