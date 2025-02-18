package com.actico.architecture.testing.joyoftesting.switchhandling;


public class SwitchHandling {

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
}
