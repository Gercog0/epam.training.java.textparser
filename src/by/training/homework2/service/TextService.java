package by.training.homework2.service;

import by.training.homework2.comparator.SymbolEntriesLexemeComparator;
import by.training.homework2.comparator.TotalLexemeLengthComparator;
import by.training.homework2.composite.TextComponent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;;

public class TextService {
    private static Logger logger = LogManager.getLogger(TextService.class);

    public TextService() {
        logger.debug("TextService was created.");
    }

    public List<TextComponent> sortParagraphsByQuantitySentences(TextComponent component) {
        List<TextComponent> sortedList = component.getComponents();
        sortedList.sort(Comparator.comparingInt(a -> a.getComponents().size()));
        return sortedList;
    }

    public List<TextComponent> sortSentencesByLengthLexeme(TextComponent component) {
        List<TextComponent> sortedList = component.getComponents();
        sortedList.sort(new TotalLexemeLengthComparator());
        return sortedList;
    }

    public List<TextComponent> sortLexemesBySymbol(TextComponent component, char symbol) {
        List<TextComponent> sortedList = component.getComponents();
        sortedList.sort(new SymbolEntriesLexemeComparator(symbol));
        return sortedList;
    }
}
