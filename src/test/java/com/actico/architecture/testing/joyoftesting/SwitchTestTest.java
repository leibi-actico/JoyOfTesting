package com.actico.architecture.testing.joyoftesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class SwitchTestTest {


    @Test
    void oldSchool() {
        assertThat(SwitchTest.oldSchool(SwitchTest.Switch.ON)).isEqualTo("Switch is ON");
        assertThat(SwitchTest.oldSchool(SwitchTest.Switch.OFF)).isEqualTo("Switch is OFF");
    }

    @Test
    void switchExpressions() {
        assertThat(SwitchTest.switchExpressions(SwitchTest.Switch.ON)).isEqualTo("Switch is ON");
        assertThat(SwitchTest.switchExpressions(SwitchTest.Switch.OFF)).isEqualTo("Switch is OFF");
    }


    @ParameterizedTest
    @EnumSource(SwitchTest.Switch.class)
    void oldSchool(SwitchTest.Switch s) {
        if (s == SwitchTest.Switch.ON) {
            assertThat(SwitchTest.oldSchool(s)).isEqualTo("Switch is ON");
        } else if (s == SwitchTest.Switch.OFF) {
            assertThat(SwitchTest.oldSchool(s)).isEqualTo("Switch is OFF");
        } else {
            assertThat(SwitchTest.oldSchool(s)).isEqualTo("Switch is in unknown state");
        }

    }

    @ParameterizedTest
    @EnumSource(SwitchTest.Switch.class)
    void switchExpressions(SwitchTest.Switch s) {
        if (s == SwitchTest.Switch.ON) {
            assertThat(SwitchTest.switchExpressions(s)).isEqualTo("Switch is ON");
        } else if (s == SwitchTest.Switch.OFF) {
            assertThat(SwitchTest.switchExpressions(s)).isEqualTo("Switch is OFF");
        }
    }

}