package parser;

import by.training.homework2.exception.ProjectException;
import by.training.homework2.parser.impl.ParagraphParser;
import by.training.homework2.parser.impl.SentenceParser;
import by.training.homework2.reader.DataReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SentenceParserTest {
    private SentenceParser parser;
    private String currentText;
    private final static String FILEPATH = "resources.data.txt";

    @BeforeClass
    public void setUp() throws ProjectException {
        parser = SentenceParser.getInstance();
        currentText = new DataReader().readAll(FILEPATH);
    }

    @Test
    public void parseTestValid() {
        int expectedSentences = 1;
        int actualSentences = parser.parse(currentText).getComponents().size();
        assertEquals(expectedSentences, actualSentences);
    }

    @Test
    public void parseTestInvalid() {
        int expectedSentences = 7;
        int actualSentences = parser.parse(currentText).getComponents().size();
        assertNotEquals(expectedSentences, actualSentences);
    }

    @AfterClass
    public void tierDown() {
        parser = null;
    }
}
