package org.example.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.example.function.util.BiConsumer;
import org.example.function.util.Consumer;
import org.example.function.util.Predicate;

public class FunctionMain {

    public static void printRandomDoubles(Supplier<Double> randomSupplier,
        int count){
        for (int i = 0; i < count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
    public static void process(List<Integer> inputs, Consumer<Integer> processor){
        for(Integer input: inputs){
            processor.accept(input);
        }
    }

    public static <T> void process(List<T> inputs, BiConsumer<Integer, T> biConsumer){
        for (int i = 0; i < inputs.size(); i++) {
            biConsumer.accept(i, inputs.get(i));
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

        /* BiConsumer */
        List<Double> doubleInputs = Arrays.asList(4.2,2.3,3.0);
        BiConsumer<Integer, Double> myBiConsumer =
            (index, input) ->
                System.out.println("Processing "+input+" at index " +index);
        process(doubleInputs, myBiConsumer);

        /* Predicate */
        Predicate<Integer> isPositive = x -> x > 0;
        List<Integer> inputs = Arrays.asList(-9,10,6,-2,5);
        System.out.println("Positive Number: "+filter(inputs,isPositive));
    }
    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition){
        List<T> output = new ArrayList<>();
        for(T input: inputs){
            if(condition.test(input)) output.add(input);
        }
        return output;
    }
}