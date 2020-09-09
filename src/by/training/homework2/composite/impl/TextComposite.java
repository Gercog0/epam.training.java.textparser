package by.training.homework2.composite.impl;

import by.training.homework2.composite.TextComponent;
import by.training.homework2.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final String REGEX_PARAGRAPH = "\n\t";
    private static final String REGEX_SPACE = " ";

    private TextComponentType currentType;
    private List<TextComponent> components;

    public TextComposite(TextComponentType textComponentType) {
        this.currentType = textComponentType;
        this.components = new ArrayList<>();
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public TextComponentType getComponentType() {
        return currentType;
    }

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite that = (TextComposite) o;

        if (currentType != that.currentType) {
            return false;
        }
        return components != null ? components.equals(that.components) : that.components == null;
    }

    @Override
    public int hashCode() {
        int result = currentType != null ? currentType.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (TextComponent component : components) {
            if (TextComponentType.PARAGRAPH.equals(component.getComponentType())) {
                builder.append(REGEX_PARAGRAPH);
            }
            if (TextComponentType.LEXEME.equals(component.getComponentType())) {
                builder.append(REGEX_SPACE);
            }

            builder.append(component.toString().trim());
        }
        return builder.toString();
    }
}
