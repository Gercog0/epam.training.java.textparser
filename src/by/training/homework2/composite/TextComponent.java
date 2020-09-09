package by.training.homework2.composite;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    TextComponent getChild(int index);

    TextComponentType getComponentType();

    List<TextComponent> getComponents();
}
