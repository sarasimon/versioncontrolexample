package org.kata;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    Map<String, BiFunction<Integer, Integer, Integer>> mapjava8 = new HashMap<>();

    public Calculator(){

        mapjava8.put("+", (first, last) -> first + last);
        mapjava8.put("-", (first, last) -> first - last);
        mapjava8.put("*", (first, last) -> first * last);
        mapjava8.put("/", (first, last) -> first / last);

    }

    public int evaluate(String expression) {
        String[] items = expression.split(" ");

        if (items.length == 1) {
            return Integer.parseInt(expression);
        } else {
            BiFunction<Integer, Integer, Integer> operator = mapjava8.get(items[2]);
            if (operator == null) {
                return 0;
            }
            return operator.apply(Integer.parseInt(items[0]), Integer.parseInt(items[1]));
        }
    }


}
