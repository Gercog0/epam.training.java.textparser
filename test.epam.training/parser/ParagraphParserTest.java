package parser;

import by.training.homework2.exception.ProjectException;
import by.training.homework2.parser.impl.ParagraphParser;
import by.training.homework2.reader.DataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {
    private ParagraphParser parser;
    private String currentText;
    private final static String FILEPATH = "resources.data.txt";

    @BeforeClass
    public void setUp() throws ProjectException {
        parser = ParagraphParser.getInstance();
        currentText = new DataReader().readAll(FILEPATH);
    }

    @Test
    public void parseTestValid() {
        int expectedParagraphs = 4;
        int actualParagraphs = parser.parse(currentText).getComponents().size();
        assertEquals(expectedParagraphs, actualParagraphs);
    }

    @Test
    public void parseTestInvalid() {
        int expectedParagraphs = 2;
        int actualParagraphs = parser.parse(currentText).getComponents().size();
        assertNotEquals(expectedParagraphs, actualParagraphs);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}
