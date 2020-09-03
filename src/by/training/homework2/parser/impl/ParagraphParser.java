package by.training.homework2.parser.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;
import by.training.homework2.composite.impl.TextComposite;
import by.training.homework2.parser.BaseParser;

public class ParagraphParser implements BaseParser {
    private static final ParagraphParser instance = new ParagraphParser();

    private static final String PARAGRAPH_REGEX = "\\n";
    private SentenceParser sentenceParser = SentenceParser.getInstance();
    private TextComponent componentSentence;
    private TextComponent componentText;

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        componentText = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_REGEX);
        for (String element : paragraphs) {
            componentSentence = sentenceParser.parse(element);
            componentText.add(componentSentence);
        }
        return componentText;
    }
}
