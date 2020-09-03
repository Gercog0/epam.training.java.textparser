package by.training.homework2.composite.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;

public class Leaf implements TextComponent {
    public enum Type {
        PUNCTUATION, CHARACTER;
    }

    private String content;
    private Type type;

    public Leaf(String symbol, Type type) {
        this.content = symbol;
        this.type = type;
    }

    // TODO: 02.09.2020 logger... 
    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException("Method is not supported");
    }

    @Override
    public TextComponentType getComponentType() {
        return TextComponentType.SYMBOL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leaf leaf1 = (Leaf) o;

        if (content.equals(leaf1.content)) {
            return false;
        }
        return type == leaf1.type;
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
