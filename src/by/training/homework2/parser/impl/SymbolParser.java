package by.training.homework2.parser.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;
import by.training.homework2.composite.impl.SymbolLeaf;
import by.training.homework2.composite.impl.TextComposite;
import by.training.homework2.parser.BaseParser;

import java.util.regex.Pattern;

public class SymbolParser implements BaseParser {
    private static final SymbolParser instance = new SymbolParser();
    private static final String LETTER_REGEX = "";
    private static final String PUNCTUATION_REGEX = "\\.{3}|[\\.,?!]";

    private SymbolParser() {
    }

    public static SymbolParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentLexeme = new TextComposite(TextComponentType.LEXEME);
        TextComponent componentLeaf;
        String[] symbols = text.split(LETTER_REGEX);
        for (String element : symbols) {
            if (Pattern.matches(PUNCTUATION_REGEX, element)) {
                componentLeaf = new SymbolLeaf(element, SymbolLeaf.Type.PUNCTUATION);
            } else {
                componentLeaf = new SymbolLeaf(element, SymbolLeaf.Type.CHARACTER);
            }
            componentLexeme.add(componentLeaf);
        }
        return componentLexeme;
    }
}
