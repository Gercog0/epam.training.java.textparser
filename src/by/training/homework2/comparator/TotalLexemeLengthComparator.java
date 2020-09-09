package by.training.homework2.comparator;

import by.training.homework2.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class TotalLexemeLengthComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return calculateTotalLexemeLength(o1) - calculateTotalLexemeLength(o2);
    }

    private int calculateTotalLexemeLength(TextComponent sentence) {
        int sum = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        for (TextComponent lexeme : lexemes) {
            sum += lexeme.toString().length();
        }
        return sum;
    }
}
