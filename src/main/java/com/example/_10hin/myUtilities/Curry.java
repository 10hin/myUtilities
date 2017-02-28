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
import java.util.function.UnaryOperator;

public interface Curry {

    static <T, U, R> Function<T, Function<U, Supplier<R>>> toSupplier(BiFunction<T, U, R> biFunction) {
        return (t) -> ((u) -> (() -> biFunction.apply(t, u)));
    }

    static <T, U, R> Function<T, Function<U, R>> toFunction(BiFunction<T, U, R> biFunction) {
        return (t) -> ((u) -> biFunction.apply(t, u));
    }

    static <T> Function<T, Function<T, Supplier<T>>> toSupplier(BinaryOperator<T> binaryOperator) {
        return (t) -> ((u) -> (() -> binaryOperator.apply(t, u)));
    }

    static <T> Function<T, Function<T, T>> toFunction(BinaryOperator<T> binaryOperator) {
        return (t1) -> ((t2) -> binaryOperator.apply(t1, t2));
    }

    static <T> Function<T, UnaryOperator<T>> toUnaryOperator(BinaryOperator<T> binaryOperator) {
        return (t1) -> ((t2) -> binaryOperator.apply(t1, t2));
    }

    static <T, U> Function<T, Function<U, Supplier<Boolean>>> toSupplier(BiPredicate<T, U> biPredicate) {
        return (t) -> ((u) -> (() -> biPredicate.test(t, u)));
    }

    static <T, U> Function<T, Function<U, Boolean>> toFunction(BiPredicate<T, U> biPredicate) {
        return (t) -> ((u) -> biPredicate.test(t, u));
    }

    static Function<Double, Function<Double, Supplier<Double>>> toSupplier(DoubleBinaryOperator binaryOperator) {
        return (d1) -> ((d2) -> (() -> binaryOperator.applyAsDouble(d1, d2)));
    }

    static Function<Double, UnaryOperator<Double>> toDoubleFunction(DoubleBinaryOperator binaryOperator) {
        return (d1) -> ((d2) -> binaryOperator.applyAsDouble(d1, d2));
    }

    static <R> Function<Double, Supplier<R>> toSupplier(DoubleFunction<R> doubleFunction) {
        return (d) -> (() -> doubleFunction.apply(d));
    }

    static Function<Double, Supplier<Boolean>> toSupplier(DoublePredicate doublePredicate) {
        return (d) -> (() -> doublePredicate.test(d));
    }

    static Function<Double, Supplier<Integer>> toSupplier(DoubleToIntFunction doubleToIntFunction) {
        return (d) -> (() -> doubleToIntFunction.applyAsInt(d));
    }

    static Function<Double, Integer> toFunction(DoubleToIntFunction doubleToIntFunction) {
        return (d) -> doubleToIntFunction.applyAsInt(d);
    }

    static Function<Double, Supplier<Long>> toSpplier(DoubleToLongFunction doubleToLongFunction) {
        return (d) -> (() -> doubleToLongFunction.applyAsLong(d));
    }

    static Function<Double, Long> toFunction(DoubleToLongFunction doubleToLongFunction) {
        return (d) -> doubleToLongFunction.applyAsLong(d);
    }

    static Function<Double, Supplier<Double>> toSupplier(DoubleUnaryOperator doubleUnaryOperator) {
        return (d) -> (() -> doubleUnaryOperator.applyAsDouble(d));
    }

    static Function<Double, Double> toFunction(DoubleUnaryOperator doubleUnaryOperator) {
        return (d) -> doubleUnaryOperator.applyAsDouble(d);
    }

    static Function<Integer, Function<Integer, Supplier<Integer>>> toSupplier(IntBinaryOperator intBinaryOperator) {
        return (i1) -> ((i2) -> (() -> intBinaryOperator.applyAsInt(i1, i2)));
    }

}
