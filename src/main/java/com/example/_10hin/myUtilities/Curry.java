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
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

public class Curry {

    private Curry() {
        // do nothing
    }

    public static <T, U, R> Function<T, Function<U, Supplier<R>>> toSupplier(BiFunction<T, U, R> biFunction) {
        return (arg0) -> ((arg1) -> (() -> biFunction.apply(arg0, arg1)));
    }

    public static <T> Function<T, Function<T, Supplier<T>>> toSupplier(BinaryOperator<T> binaryOperator) {
        return (arg0) -> ((arg1) -> (() -> binaryOperator.apply(arg0, arg1)));
    }

    public static <T, U> Function<T, Function<U, Supplier<Boolean>>> toSupplier(BiPredicate<T, U> biPredicate) {
        return (arg0) -> ((arg1) -> (() -> biPredicate.test(arg0, arg1)));
    }

    public static  Function<Double, Function<Double, Supplier<Double>>> toSupplier(DoubleBinaryOperator doubleBinaryOperator) {
        return (arg0) -> ((arg1) -> (() -> doubleBinaryOperator.applyAsDouble(arg0, arg1)));
    }

    public static <R> Function<Double, Supplier<R>> toSupplier(DoubleFunction<R> doubleFunction) {
        return (arg0) -> (() -> doubleFunction.apply(arg0));
    }

    public static  Function<Double, Supplier<Boolean>> toSupplier(DoublePredicate doublePredicate) {
        return (arg0) -> (() -> doublePredicate.test(arg0));
    }

    public static  Function<Double, Supplier<Integer>> toSupplier(DoubleToIntFunction doubleToIntFunction) {
        return (arg0) -> (() -> doubleToIntFunction.applyAsInt(arg0));
    }

    public static  Function<Double, Supplier<Long>> toSupplier(DoubleToLongFunction doubleToLongFunction) {
        return (arg0) -> (() -> doubleToLongFunction.applyAsLong(arg0));
    }

    public static  Function<Double, Supplier<Double>> toSupplier(DoubleUnaryOperator doubleUnaryOperator) {
        return (arg0) -> (() -> doubleUnaryOperator.applyAsDouble(arg0));
    }

    public static <T, R> Function<T, Supplier<R>> toSupplier(Function<T, R> function) {
        return (arg0) -> (() -> function.apply(arg0));
    }

    public static  Function<Integer, Function<Integer, Supplier<Integer>>> toSupplier(IntBinaryOperator intBinaryOperator) {
        return (arg0) -> ((arg1) -> (() -> intBinaryOperator.applyAsInt(arg0, arg1)));
    }

    public static <R> Function<Integer, Supplier<R>> toSupplier(IntFunction<R> intFunction) {
        return (arg0) -> (() -> intFunction.apply(arg0));
    }

    public static  Function<Integer, Supplier<Boolean>> toSupplier(IntPredicate intPredicate) {
        return (arg0) -> (() -> intPredicate.test(arg0));
    }

    public static  Function<Integer, Supplier<Double>> toSupplier(IntToDoubleFunction intToDoubleFunction) {
        return (arg0) -> (() -> intToDoubleFunction.applyAsDouble(arg0));
    }

    public static  Function<Integer, Supplier<Long>> toSupplier(IntToLongFunction intToLongFunction) {
        return (arg0) -> (() -> intToLongFunction.applyAsLong(arg0));
    }

    public static  Function<Integer, Supplier<Integer>> toSupplier(IntUnaryOperator intUnaryOperator) {
        return (arg0) -> (() -> intUnaryOperator.applyAsInt(arg0));
    }

    public static  Function<Long, Function<Long, Supplier<Long>>> toSupplier(LongBinaryOperator longBinaryOperator) {
        return (arg0) -> ((arg1) -> (() -> longBinaryOperator.applyAsLong(arg0, arg1)));
    }

    public static <R> Function<Long, Supplier<R>> toSupplier(LongFunction<R> longFunction) {
        return (arg0) -> (() -> longFunction.apply(arg0));
    }

    public static  Function<Long, Supplier<Boolean>> toSupplier(LongPredicate longPredicate) {
        return (arg0) -> (() -> longPredicate.test(arg0));
    }

    public static  Function<Long, Supplier<Double>> toSupplier(LongToDoubleFunction longToDoubleFunction) {
        return (arg0) -> (() -> longToDoubleFunction.applyAsDouble(arg0));
    }

    public static  Function<Long, Supplier<Integer>> toSupplier(LongToIntFunction longToIntFunction) {
        return (arg0) -> (() -> longToIntFunction.applyAsInt(arg0));
    }

    public static  Function<Long, Supplier<Long>> toSupplier(LongUnaryOperator longUnaryOperator) {
        return (arg0) -> (() -> longUnaryOperator.applyAsLong(arg0));
    }

    public static <T> Function<T, Supplier<Boolean>> toSupplier(Predicate<T> predicate) {
        return (arg0) -> (() -> predicate.test(arg0));
    }

    public static <T, U> Function<T, Function<U, Supplier<Double>>> toSupplier(ToDoubleBiFunction<T, U> toDoubleBiFunction) {
        return (arg0) -> ((arg1) -> (() -> toDoubleBiFunction.applyAsDouble(arg0, arg1)));
    }

    public static <T> Function<T, Supplier<Double>> toSupplier(ToDoubleFunction<T> toDoubleFunction) {
        return (arg0) -> (() -> toDoubleFunction.applyAsDouble(arg0));
    }

    public static <T, U> Function<T, Function<U, Supplier<Integer>>> toSupplier(ToIntBiFunction<T, U> toIntBiFunction) {
        return (arg0) -> ((arg1) -> (() -> toIntBiFunction.applyAsInt(arg0, arg1)));
    }

    public static <T> Function<T, Supplier<Integer>> toSupplier(ToIntFunction<T> toIntFunction) {
        return (arg0) -> (() -> toIntFunction.applyAsInt(arg0));
    }

    public static <T, U> Function<T, Function<U, Supplier<Long>>> toSupplier(ToLongBiFunction<T, U> toLongBiFunction) {
        return (arg0) -> ((arg1) -> (() -> toLongBiFunction.applyAsLong(arg0, arg1)));
    }

    public static <T> Function<T, Supplier<Long>> toSupplier(ToLongFunction<T> toLongFunction) {
        return (arg0) -> (() -> toLongFunction.applyAsLong(arg0));
    }

    public static <T> Function<T, Supplier<T>> toSupplier(UnaryOperator<T> unaryOperator) {
        return (arg0) -> (() -> unaryOperator.apply(arg0));
    }

    public static <T, U, R> Function<T, Function<U, R>> toFunction(BiFunction<T, U, R> biFunction) {
        return (arg0) -> ((arg1) -> biFunction.apply(arg0, arg1));
    }

    public static <T> Function<T, Function<T, T>> toFunction(BinaryOperator<T> binaryOperator) {
        return (arg0) -> ((arg1) -> binaryOperator.apply(arg0, arg1));
    }

    public static <T, U> Function<T, Function<U, Boolean>> toFunction(BiPredicate<T, U> biPredicate) {
        return (arg0) -> ((arg1) -> biPredicate.test(arg0, arg1));
    }

    public static  Function<Double, Function<Double, Double>> toFunction(DoubleBinaryOperator doubleBinaryOperator) {
        return (arg0) -> ((arg1) -> doubleBinaryOperator.applyAsDouble(arg0, arg1));
    }

    public static  Function<Integer, Function<Integer, Integer>> toFunction(IntBinaryOperator intBinaryOperator) {
        return (arg0) -> ((arg1) -> intBinaryOperator.applyAsInt(arg0, arg1));
    }

    public static  Function<Long, Function<Long, Long>> toFunction(LongBinaryOperator longBinaryOperator) {
        return (arg0) -> ((arg1) -> longBinaryOperator.applyAsLong(arg0, arg1));
    }

    public static <T, U> Function<T, Function<U, Double>> toFunction(ToDoubleBiFunction<T, U> toDoubleBiFunction) {
        return (arg0) -> ((arg1) -> toDoubleBiFunction.applyAsDouble(arg0, arg1));
    }

    public static <T, U> Function<T, Function<U, Integer>> toFunction(ToIntBiFunction<T, U> toIntBiFunction) {
        return (arg0) -> ((arg1) -> toIntBiFunction.applyAsInt(arg0, arg1));
    }

    public static <T, U> Function<T, Function<U, Long>> toFunction(ToLongBiFunction<T, U> toLongBiFunction) {
        return (arg0) -> ((arg1) -> toLongBiFunction.applyAsLong(arg0, arg1));
    }

}
