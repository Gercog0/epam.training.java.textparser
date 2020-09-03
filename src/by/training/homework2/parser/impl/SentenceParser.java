package by.training.homework2.parser.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;
import by.training.homework2.composite.impl.TextComposite;
import by.training.homework2.parser.BaseParser;

public class SentenceParser implements BaseParser {
    private static final SentenceParser instance = new SentenceParser();

    private static final String SENTENCE_REGEX = "[\\.?!]\\s? | [\\.{3}]\\s?";
    private static LexemeParser lexemeParser = LexemeParser.getInstance();
    private TextComponent componentParagraph;
    private TextComponent componentLexeme;

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        componentParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = text.split(SENTENCE_REGEX);
        for (String element : sentences) {
            componentLexeme = lexemeParser.parse(element);
            componentParagraph.add(componentLexeme);
        }
        return componentParagraph;
    }
}
