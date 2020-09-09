package parser;

import by.training.homework2.exception.ProjectException;
import by.training.homework2.parser.impl.LexemeParser;
import by.training.homework2.reader.DataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LexemeParserTest {
    private LexemeParser parser;
    private String currentText;
    private final static String FILEPATH = "resources.data.txt";

    @BeforeClass
    public void setUp() throws ProjectException {
        parser = LexemeParser.getInstance();
        currentText = new DataReader().readAll(FILEPATH);
    }

    @Test
    public void parseTestValid() {
        int expectedLexeme = 123;
        int actualLexeme = parser.parse(currentText).getComponents().size();
        assertEquals(expectedLexeme, actualLexeme);
    }

    @Test
    public void parseTestInvalid() {
        int expectedLexeme = 7;
        int actualLexeme = parser.parse(currentText).getComponents().size();
        assertNotEquals(expectedLexeme, actualLexeme);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}
