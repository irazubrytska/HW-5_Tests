package example.junit;

import org.example.MyCalculator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherCalcTests {

    private MyCalculator calc = new MyCalculator();

    @Tag("CalculatorTest")
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 5, 10})
    void testSqrIsPositive(int number) {
        int res = calc.sqr(number);
        assertTrue(res >= 0);
    }
}
