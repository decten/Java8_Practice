package org.example.lambda;

import org.example.lambda.util.TriFunction;

public class LambdaMain {

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers =
            (x, y, z) -> x+y+z;

        int result = addThreeNumbers.apply(3,2,1);
        System.out.println(result);
    }
}