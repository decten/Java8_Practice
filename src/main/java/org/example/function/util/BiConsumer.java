package org.example.function.util;

@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
