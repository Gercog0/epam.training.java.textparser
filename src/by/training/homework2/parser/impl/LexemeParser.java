package by.training.homework2.parser.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;
import by.training.homework2.composite.impl.TextComposite;
import by.training.homework2.parser.BaseParser;
import by.training.homework2.interpreter.TextInterpreter;

import java.util.regex.Pattern;

public class LexemeParser implements BaseParser {
    private static final LexemeParser instance = new LexemeParser();

    private static final String LEXEME_REGEX = " ";
    private static final String REGEX_CONDITION_CALCULATION = "\\p{N}+";

    private static SymbolParser symbolParser = SymbolParser.getInstance();

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentSentence = new TextComposite(TextComponentType.SENTENCE);
        TextComponent componentSymbol;
        String[] lexemes = text.split(LEXEME_REGEX);

        Pattern pattern = Pattern.compile(REGEX_CONDITION_CALCULATION);

        for (int i = 0; i < lexemes.length; i++) {
            if (pattern.matcher(lexemes[i]).find()) {
                lexemes[i] = TextInterpreter.convertExpression(lexemes[i]);
            }
        }

        for (String element : lexemes) {
            componentSymbol = symbolParser.parse(element);
            componentSentence.add(componentSymbol);
        }
        return componentSentence;
    }
}
