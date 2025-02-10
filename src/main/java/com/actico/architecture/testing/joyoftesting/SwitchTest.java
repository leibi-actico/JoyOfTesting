package com.actico.architecture.testing.joyoftesting;

public class SwitchTest {

    public enum Switch {
        ON, OFF
    }

    public static String oldSchool(Switch s) {
        switch (s) {
            case ON:
                return "Switch is ON";
            case OFF:
                return "Switch is OFF";
            default:
                return "Switch is in unknown state";
        }
    }


    public static String switchExpressions(Switch s) {
        return switch (s) {
            case ON -> "Switch is ON";
            case OFF -> "Switch is OFF";
        };
    }

}
