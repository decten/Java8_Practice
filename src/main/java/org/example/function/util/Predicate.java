package org.example.function.util;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
