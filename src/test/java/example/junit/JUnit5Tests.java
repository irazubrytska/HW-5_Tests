package example.junit;

import org.example.MyCalculator;
import org.example.MyColor;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class JUnit5Tests {
    private MyCalculator calc = new MyCalculator();

    @Tag("CalculatorTest")
    @Test
    public void testCalcHistory() {
        calc.clearHistory();
        assertThat(calc.solutionHistory.isEmpty());
    }

    @Tag("CalculatorTest")
    @ParameterizedTest
    @MethodSource("divisionParams")
    public void testParamDivision(int a, int b) {
        assumeTrue(b!=0);
        calc.divide(a, b);
    }

    private static Stream<Arguments> divisionParams() {
        return Stream.of(
                Arguments.of(10, 0),
                Arguments.of(10, 1),
                Arguments.of(10, 5)
        );
    }

    @Tag("ColorTest")
    @ParameterizedTest
    @MethodSource("colorParams")
    void testColors(MyColor color) {
        assertThat(color.red >= 0 && color.red <= 255);
        assertThat(color.green >= 0 && color.green <= 255);
        assertThat(color.blue >= 0 && color.blue <= 255);
    }

    private static Stream<Arguments> colorParams() {
        return Stream.of(
                Arguments.of(new MyColor(100,100,100)),
                Arguments.of(new MyColor(255,0,0)),
                Arguments.of(new MyColor(10,20,30))
        );
    }

}
