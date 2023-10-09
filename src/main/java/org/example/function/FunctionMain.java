package org.example.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.example.function.util.Consumer;

public class FunctionMain {

    public static void printRandomDoubles(Supplier<Double> randomSupplier,
        int count){
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
    public static void main(String[] args) {
        /* Supplier */
        Supplier<String> myStringSupplier = () -> "hello supplier";
        System.out.println(myStringSupplier.get());

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        System.out.println(myRandomDoubleSupplier.get());
        System.out.println(myRandomDoubleSupplier.get());

        printRandomDoubles(myRandomDoubleSupplier, 2);

        /* Consumer */
        Consumer<String> myStringConsumer = (String str) -> System.out.println(str);
        myStringConsumer.accept("hello consumer");

        List<Integer> integerInputs = Arrays.asList(4,2,3);
        Consumer<Integer> myIntegerConsumer = (Integer x) ->
            System.out.println("Processing Integer: "+x);
        process(integerInputs,myIntegerConsumer);
    }

    public static void process(List<Integer> inputs, Consumer<Integer> processor){
        for(Integer input: inputs){
            processor.accept(input);
        }
    }
}