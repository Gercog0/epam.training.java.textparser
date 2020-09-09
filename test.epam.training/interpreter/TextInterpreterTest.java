package interpreter;

import by.training.homework2.interpreter.TextInterpreter;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class TextInterpreterTest {
    @Test
    public void convertExpressionTextValid() {
        String expected = "19";
        String actual = TextInterpreter.convertExpression("17+3-1");
        assertEquals(expected, actual);
    }

    @Test
    public void convertExpressionTextInvalid() {
        String expected = "21";
        String actual = TextInterpreter.convertExpression("17+3-1");
        assertNotEquals(expected, actual);
    }
}
