package org.example.method;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceMain {

    /* 3. 클래스의 instance method */
    static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    static int multiply(int x, int y) {
        return x * y;
    }

    /* 4. 객체의 constructor */
    int subtract(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {
        /* 1. 클래스의 static method */
        Function<String, Integer> strToInt = Integer::parseInt;
        System.out.println(strToInt.apply("20"));

        /* 2. 객체의 instance method */
        String s = "hello";
        Predicate<String> equalsToHello = s::equals;
        System.out.println(equalsToHello.test("world"));

        /* 3. 클래스의 instance method */
        System.out.println(calculate(8, 2, MethodReferenceMain::multiply));

        /* 4. 객체의 constructor */
        MethodReferenceMain instance = new MethodReferenceMain();
        System.out.println(calculate(8, 2, instance::subtract));
    }
}