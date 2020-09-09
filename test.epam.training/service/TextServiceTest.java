package service;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.exception.ProjectException;
import by.training.homework2.parser.impl.LexemeParser;
import by.training.homework2.parser.impl.ParagraphParser;
import by.training.homework2.reader.DataReader;
import by.training.homework2.service.TextService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class TextServiceTest {
    private TextService service;
    private String text;

    @BeforeClass
    public void setUp() throws ProjectException {
        service = new TextService();
        text = new DataReader().readAll("resources/data.txt");
    }

    @Test
    public void sortParagraphsByQuantitySentencesTestValid() {
        String expected = "[It has survived - not only (five) centuries, but also the leap into 16 electronic typesetting, remaining 8 essentially -3 unchanged. It was popularised in the 125 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum., " +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 350.0 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English., " +
                "It is a 0.0 established fact that a reader will be of a page when looking at its layout., " +
                "Bye.]";
        TextComponent component = ParagraphParser.getInstance().parse(text);
        String actual = service.sortParagraphsByQuantitySentences(component).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void sortParagraphsByQuantitySentencesTestInvalid() {
        String expected = "It has survived - not only (five) centuries, but also the leap into 16 electronic typesetting, remaining 8 essentially -3 unchanged. It was popularised in the 125 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum., " +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 350.0 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English., " +
                "It is a 0.0 established fact that a reader will be of a page when looking at its layout., " +
                "Bye.";
        TextComponent component = ParagraphParser.getInstance().parse(text);
        String actual = service.sortParagraphsByQuantitySentences(component).toString();
        assertNotEquals(expected, actual);
    }

    @Test
    public void sortSentencesByLengthLexemeValid() {
        String expected = "[Bye., It is a 0.0 established fact that a reader will be of a page when looking at its layout., It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 350.0 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English., It has survived - not only (five) centuries, but also the leap into 16 electronic typesetting, remaining 8 essentially -3 unchanged. It was popularised in the 125 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.]";
        TextComponent component = ParagraphParser.getInstance().parse(text);
        String actual = service.sortSentencesByLengthLexeme(component).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void sortSentencesByLengthLexemeInvalid() {
        String expected = "Bye., It is a 0.0 established fact that a reader will be of a page when looking at its layout., It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 350.0 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English., It has survived - not only (five) centuries, but also the leap into 16 electronic typesetting, remaining 8 essentially -3 unchanged. It was popularised in the 125 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.]";
        TextComponent component = ParagraphParser.getInstance().parse(text);
        String actual = service.sortSentencesByLengthLexeme(component).toString();
        assertNotEquals(expected, actual);
    }

    @Test
    public void sortLexemesBySymbolTestValid() {
        String expected = "[-, -3, 0.0, 125, 16, 350.0, 8, Aldus, English.It, Ipsum, Ipsum, Ipsum.It, It, It, a, a, a, a, a, a, a, also, and, as, at, at, but, by, containing, distribution, fact, fact, has, has, in, including, into, is, is, is, it, it, its, its, layout., long, look, looking, looking, making, normal, not, of, of, of, of, of, of, only, point, publishing, that, that, that, to, using, using, was, will, will, with, with, (Content, (five), Lorem, Lorem, The, be, be, content, content, desktop, distracted, layout.Bye., leap, like, like, more, opposed, page, page, passages,, popularised, remaining, software, survived, the, the, the, the, unchanged., versions, when, when, Letraset, PageMaker, centuries,, electronic, essentially, established, established, here',, here),, letters,, more-or-less, readable, readable, reader, reader, recently, sheets, typesetting,, release]";
        TextComponent component = LexemeParser.getInstance().parse(text);
        String actual = service.sortLexemesBySymbol(component, 'e').toString();
        assertEquals(expected, actual);
    }

    @Test
    public void sortLexemesBySymbolTestInvalid() {
        String expected = "-, -3, 0.0, 125, 16, 350.0, 8, Aldus, English.It, Ipsum, Ipsum, Ipsum.It, It, It, a, a, a, a, a, a, a, also, and, as, at, at, but, by, containing, distribution, fact, fact, has, has, in, including, into, is, is, is, it, it, its, its, layout., long, look, looking, looking, making, normal, not, of, of, of, of, of, of, only, point, publishing, that, that, that, to, using, using, was, will, will, with, with, (Content, (five), Lorem, Lorem, The, be, be, content, content, desktop, distracted, layout.Bye., leap, like, like, more, opposed, page, page, passages,, popularised, remaining, software, survived, the, the, the, the, unchanged., versions, when, when, Letraset, PageMaker, centuries,, electronic, essentially, established, established, here',, here),, letters,, more-or-less, readable, readable, reader, reader, recently, sheets, typesetting,, release]";
        TextComponent component = LexemeParser.getInstance().parse(text);
        String actual = service.sortLexemesBySymbol(component, 'e').toString();
        assertNotEquals(expected, actual);
    }


    @AfterClass
    public void tierDown() {
        service = null;
    }
}
