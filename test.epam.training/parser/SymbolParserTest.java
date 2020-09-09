package parser;

import by.training.homework2.exception.ProjectException;
import by.training.homework2.parser.impl.SymbolParser;
import by.training.homework2.reader.DataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SymbolParserTest {
    private SymbolParser parser;
    private String currentText;
    private final static String FILEPATH = "resources.data.txt";

    @BeforeClass
    public void setUp() throws ProjectException {
        parser = SymbolParser.getInstance();
        currentText = new DataReader().readAll(FILEPATH);
    }

    @Test
    public void parseTestValid() {
        int expectedSymbols = 827;
        int actualSymbols = parser.parse(currentText).getComponents().size();
        assertEquals(expectedSymbols, actualSymbols);
    }

    @Test
    public void parseTestInvalid() {
        int expectedSymbols = 7;
        int actualSymbols = parser.parse(currentText).getComponents().size();
        assertNotEquals(expectedSymbols, actualSymbols);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}
