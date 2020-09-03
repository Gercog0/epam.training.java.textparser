package by.training.homework2.parser.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;
import by.training.homework2.composite.impl.TextComposite;
import by.training.homework2.parser.BaseParser;

public class LexemeParser implements BaseParser {
    private static final LexemeParser instance = new LexemeParser();

    private static final String LEXEME_REGEX = " ";
    private static SymbolParser symbolParser = SymbolParser.getInstance();
    private TextComponent componentSentence;
    private TextComponent componentSymbol;

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        componentSentence = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = text.split(LEXEME_REGEX);
        for (String element : lexemes) {
            componentSymbol = symbolParser.parse(element);
            componentSentence.add(componentSymbol);
        }
        return componentSentence;
    }
}
