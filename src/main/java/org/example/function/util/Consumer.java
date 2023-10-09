package org.example.function.util;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
