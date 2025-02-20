package com.actico.architecture.testing.joyoftesting.switchhandling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Fail.fail;

class SwitchHandlingTest {


    @Test
    void enumValueOnShouldReturnSwitchOn() {
        assertThat(SwitchHandling.oldSchool(SwitchHandling.Switch.ON)).isEqualTo("Switch is ON");
    }

    @Test
    void enumValueOffShouldReturnSwitchOff() {
        assertThat(SwitchHandling.oldSchool(SwitchHandling.Switch.OFF)).isEqualTo("Switch is OFF");
    }


    @ParameterizedTest
    @EnumSource(SwitchHandling.Switch.class)
    void allEnumValuesShouldBeTested(SwitchHandling.Switch s) {
        if (s == SwitchHandling.Switch.ON) {
            assertThat(SwitchHandling.oldSchool(s)).isEqualTo("Switch is ON");
        } else if (s == SwitchHandling.Switch.OFF) {
            assertThat(SwitchHandling.oldSchool(s)).isEqualTo("Switch is OFF");
        } else {
            fail("Unknown enum value: " + s);
        }
    }

    @Test
    void nullEnumValue_whenPassedAsArgumentToOldSchool_shouldRaiseNullpointerexception() {
        assertThatThrownBy(() -> SwitchHandling.oldSchool(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Cannot invoke \"com.actico.architecture.testing.joyoftesting.switchhandling.SwitchHandling$Switch.ordinal()\" because \"s\" is null");
    }

}