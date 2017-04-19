package com.example._10hin.myUtilities;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

public class Curry {

    private Curry() {
        // do nothing
    }

    public static <T, U, R> Function<T, Function<U, Supplier<R>>> toSupplier(BiFunction<T, U, R> biFunction) {
        return (t) -> ((u) -> (() -> biFunction.apply(t, u)));
    }

    public static <T, U, R> Function<T, Function<U, R>> toFunction(BiFunction<T, U, R> biFunction) {
        return (t) -> ((u) -> biFunction.apply(t, u));
    }

    public static <T> Function<T, Function<T, Supplier<T>>> toSupplier(BinaryOperator<T> binaryOperator) {
        return (t) -> ((u) -> (() -> binaryOperator.apply(t, u)));
    }

    public static <T> Function<T, Function<T, T>> toFunction(BinaryOperator<T> binaryOperator) {
        return (t1) -> ((t2) -> binaryOperator.apply(t1, t2));
    }

   public static <T, U> Function<T, Function<U, Supplier<Boolean>>> toSupplier(BiPredicate<T, U> biPredicate) {
        return (t) -> ((u) -> (() -> biPredicate.test(t, u)));
    }

    public static <T, U> Function<T, Function<U, Boolean>> toFunction(BiPredicate<T, U> biPredicate) {
        return (t) -> ((u) -> biPredicate.test(t, u));
    }

    public static Function<Double, Function<Double, Supplier<Double>>> toSupplier(DoubleBinaryOperator binaryOperator) {
        return (d1) -> ((d2) -> (() -> binaryOperator.applyAsDouble(d1, d2)));
    }

    public static <R> Function<Double, Supplier<R>> toSupplier(DoubleFunction<R> doubleFunction) {
        return (d) -> (() -> doubleFunction.apply(d));
    }

    public static Function<Double, Supplier<Boolean>> toSupplier(DoublePredicate doublePredicate) {
        return (d) -> (() -> doublePredicate.test(d));
    }

    public static Function<Double, Supplier<Integer>> toSupplier(DoubleToIntFunction doubleToIntFunction) {
        return (d) -> (() -> doubleToIntFunction.applyAsInt(d));
    }

    public static Function<Double, Supplier<Long>> toSpplier(DoubleToLongFunction doubleToLongFunction) {
        return (d) -> (() -> doubleToLongFunction.applyAsLong(d));
    }

    public static Function<Double, Supplier<Double>> toSupplier(DoubleUnaryOperator doubleUnaryOperator) {
        return (d) -> (() -> doubleUnaryOperator.applyAsDouble(d));
    }

    public static Function<Integer, Function<Integer, Supplier<Integer>>> toSupplier(IntBinaryOperator intBinaryOperator) {
        return (i1) -> ((i2) -> (() -> intBinaryOperator.applyAsInt(i1, i2)));
    }

}
