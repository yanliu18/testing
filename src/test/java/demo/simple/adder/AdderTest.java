package demo.simple.adder;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yuan-Fang Li & Yan Liu
 * @version $Id: 02$
 */
public class AdderTest {
    private Adder adder;

    @BeforeEach
    public void setUp() {
        adder = new Adder();
    }

    @Test
    public void shouldConstructAdder() {
        assertNotNull(adder);
    }
/* ----------------------------------------------------------------------------------------
 * accepts a non-null string argument representing 0, 1, or 2 integers, separated by commas
 * returns their sum (for an empty string the adder will return 0)
 */
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void shouldReturnZeroWhenGivenEmptyStrings(String arg) {
        assertEquals(0, adder.add(arg));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "10"})
    public void shouldReturnItselfWhenGivenOneIntInput(String arg) {
        assertEquals(Integer.parseInt(arg), adder.add(arg));
    }

    @Test
    public void shouldAddTwoIntegersCorrectly() {
        assertEquals(1 + 5, adder.add("1, 5"));
    }


/* ------------------------------------------------------------------------------------------
 * Todo: With null argument, it should throw illegal argument exception
 */
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGivenNull() {
        assertThrows(IllegalArgumentException.class, () -> adder.add(null));
    }

/* ------------------------------------------------------------------------------------------
 * Todo: Handle non-int input.
 */
    @ParameterizedTest
    @ValueSource(strings = {"0,x", "x", "0, x, 1"})
    public void shouldThrowNumberFormatExceptionIfGivenNonIntInput(String arg) {
        assertThrows(NumberFormatException.class, () -> adder.add(arg));
    }

/* ------------------------------------------------------------------------------------------
 * Todo: Handle more than 2 int inputs.
 */

    @Test
    public void shouldAddThreeIntegersCorrectly() {
        assertEquals(1 + 5 + 10, adder.add("1, 5,10"));
    }

/* ------------------------------------------------------------------------------------------
 * Todo:Negative numbers input should throw an exception
 */

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0, -1", "-1, -1"})
    public void shouldThrowIllegalArgumentExceptionWhenGivenNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> adder.add("-1"));
    }
}