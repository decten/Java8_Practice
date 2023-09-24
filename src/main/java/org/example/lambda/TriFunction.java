package org.example.lambda;

@FunctionalInterface
//매개변수 T,U,V 3개를 받아 R 리턴
public interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}
