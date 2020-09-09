package by.training.homework2.comparator;

import by.training.homework2.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class SymbolEntriesLexemeComparator implements Comparator<TextComponent> {
    private final char symbol;

    public SymbolEntriesLexemeComparator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int difference = calculateTotalEntriesSymbolInLexeme(o1, symbol)
                - calculateTotalEntriesSymbolInLexeme(o2, symbol);
        if (difference == 0) {
            return new AlphabeticLexemeComparator().compare(o1, o2);
        }
        return difference;
    }

    private int calculateTotalEntriesSymbolInLexeme(TextComponent lexeme, char symbol) {
        List<TextComponent> symbols = lexeme.getComponents();
        int counter = 0;
        for (TextComponent element : symbols) {
            if (Character.toString(symbol).equals(element.toString())) {
                counter++;
            }
        }
        return counter;
    }
}
