package main;

import java.util.function.Predicate;

/**
 * Created by Mihail Lobanov on 13.11.2016.
 */
public class PredicateFilter {
    private String operator;
    private int operand2;
    private int operand3;

    /*
    Во всех случаях кроме нахождения остатка от деления operand3 фиктивный.
     */
    public PredicateFilter(String operator, int operand2, int operand3) {
        this.operator = operator;
        this.operand2 = operand2;
        this.operand3 = operand3;
    }

    public boolean hasPredicate(int operand) {
        boolean predicate = false;
        switch (operator) {
            case ">":
                Predicate<Integer> isPositive = x -> x > operand2;
                predicate = isPositive.test(operand);
                break;
            case "<":
                Predicate<Integer> isPositive2 = x -> x < operand2;
                predicate = isPositive2.test(operand);
                break;
            case "<=":
                Predicate<Integer> isPositive3 = x -> x <= operand2;
                predicate = isPositive3.test(operand);
                break;
            case ">=":
                Predicate<Integer> isPositive4 = x -> x >= operand2;
                predicate = isPositive4.test(operand);
                break;
            case "==":
                Predicate<Integer> isPositive5 = x -> x == operand2;
                predicate = isPositive5.test(operand);
                break;
            case "%":
                Predicate<Integer> isPositive6 = x -> x % operand2 == operand3;
                predicate = isPositive6.test(operand);
                break;
        }
        return predicate;
    }
}