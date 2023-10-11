package org.example.function.util;

@FunctionalInterface
public interface BiConsumer<T, S> {
    void accept(T t, S s);
}
