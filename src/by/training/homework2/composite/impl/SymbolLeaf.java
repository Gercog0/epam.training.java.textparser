package by.training.homework2.composite.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class SymbolLeaf implements TextComponent {
    public enum Type {
        PUNCTUATION, CHARACTER;
    }

    private String content;
    private Type type;

    private static final Logger logger = LogManager.getLogger(SymbolLeaf.class);

    public SymbolLeaf(String symbol, Type type) {
        this.content = symbol;
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        logger.fatal("Method is not available...");
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public void remove(TextComponent component) {
        logger.fatal("Method is not available...");
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public TextComponent getChild(int index) {
        logger.fatal("Method is not available...");
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public TextComponentType getComponentType() {
        return TextComponentType.SYMBOL;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SymbolLeaf symbolLeaf1 = (SymbolLeaf) o;

        if (content.equals(symbolLeaf1.content)) {
            return false;
        }
        return type == symbolLeaf1.type;
    }

    @Override
    public int hashCode() {
        int result = Integer.parseInt(content);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return content;
    }
}
