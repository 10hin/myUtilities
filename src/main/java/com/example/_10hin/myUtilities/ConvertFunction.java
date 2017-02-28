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
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

public interface ConvertFunction {

    static <R> Function<Double, R> asFunction(DoubleFunction<R> doubleFunction) {
        return (arg0) -> doubleFunction.apply(arg0);
    }

    static Function<Double, Boolean> asFunction(DoublePredicate doublePredicate) {
        return (arg0) -> doublePredicate.test(arg0);
    }

    static Function<Double, Integer> asFunction(DoubleToIntFunction doubleToIntFunction) {
        return (arg0) -> doubleToIntFunction.applyAsInt(arg0);
    }

    static Function<Double, Long> asFunction(DoubleToLongFunction doubleToLongFunction) {
        return (arg0) -> doubleToLongFunction.applyAsLong(arg0);
    }

    static Function<Double, Double> asFunction(DoubleUnaryOperator doubleUnaryOperator) {
        return (arg0) -> doubleUnaryOperator.applyAsDouble(arg0);
    }

    static <R> Function<Integer, R> asFunction(IntFunction<R> intFunction) {
        return (arg0) -> intFunction.apply(arg0);
    }

    static Function<Integer, Boolean> asFunction(IntPredicate intPredicate) {
        return (arg0) -> intPredicate.test(arg0);
    }

    static Function<Integer, Double> asFunction(IntToDoubleFunction intToDoubleFunction) {
        return (arg0) -> intToDoubleFunction.applyAsDouble(arg0);
    }

    static Function<Integer, Long> asFunction(IntToLongFunction intToLongFunction) {
        return (arg0) -> intToLongFunction.applyAsLong(arg0);
    }

    static Function<Integer, Integer> asFunction(IntUnaryOperator intUnaryOperator) {
        return (arg0) -> intUnaryOperator.applyAsInt(arg0);
    }

    static <R> Function<Long, R> asFunction(LongFunction<R> longFunction) {
        return (arg0) -> longFunction.apply(arg0);
    }

    static Function<Long, Boolean> asFunction(LongPredicate longPredicate) {
        return (arg0) -> longPredicate.test(arg0);
    }

    static Function<Long, Double> asFunction(LongToDoubleFunction longToDoubleFunction) {
        return (arg0) -> longToDoubleFunction.applyAsDouble(arg0);
    }

    static Function<Long, Integer> asFunction(LongToIntFunction longToIntFunction) {
        return (arg0) -> longToIntFunction.applyAsInt(arg0);
    }

    static Function<Long, Long> asFunction(LongUnaryOperator longUnaryOperator) {
        return (arg0) -> longUnaryOperator.applyAsLong(arg0);
    }

    static <T> Function<T, Boolean> asFunction(Predicate<T> predicate) {
        return (arg0) -> predicate.test(arg0);
    }

    static <T> Function<T, Double> asFunction(ToDoubleFunction<T> toDoubleFunction) {
        return (arg0) -> toDoubleFunction.applyAsDouble(arg0);
    }

    static <T> Function<T, Integer> asFunction(ToIntFunction<T> toIntFunction) {
        return (arg0) -> toIntFunction.applyAsInt(arg0);
    }

    static <T> Function<T, Long> asFunction(ToLongFunction<T> toLongFunction) {
        return (arg0) -> toLongFunction.applyAsLong(arg0);
    }

    static <T> Function<T, T> asFunction(UnaryOperator<T> unaryOperator) {
        return (arg0) -> unaryOperator.apply(arg0);
    }

    static DoubleUnaryOperator asDoubleUnaryOperator(Function<Double, Double> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <R> IntFunction<R> asIntFunction(Function<Integer, R> function) {
        return (arg0) -> function.apply(arg0);
    }

    static IntPredicate asIntPredicate(Function<Integer, Boolean> function) {
        return (arg0) -> function.apply(arg0);
    }

    static IntToDoubleFunction asIntToDoubleFunction(Function<Integer, Double> function) {
        return (arg0) -> function.apply(arg0);
    }

    static IntToLongFunction asIntToLongFunction(Function<Integer, Long> function) {
        return (arg0) -> function.apply(arg0);
    }

    static IntUnaryOperator asIntUnaryOperator(Function<Integer, Integer> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <R> LongFunction<R> asLongFunction(Function<Long, R> function) {
        return (arg0) -> function.apply(arg0);
    }

    static LongPredicate asLongPredicate(Function<Long, Boolean> function) {
        return (arg0) -> function.apply(arg0);
    }

    static LongToDoubleFunction asLongToDoubleFunction(Function<Long, Double> function) {
        return (arg0) -> function.apply(arg0);
    }

    static LongToIntFunction asLongToIntFunction(Function<Long, Integer> function) {
        return (arg0) -> function.apply(arg0);
    }

    static LongUnaryOperator asLongUnaryOperator(Function<Long, Long> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <T> Predicate<T> asPredicate(Function<T, Boolean> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <T> ToDoubleFunction<T> asToDoubleFunction(Function<T, Double> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <T> ToIntFunction<T> asToIntFunction(Function<T, Integer> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <T> ToLongFunction<T> asToLongFunction(Function<T, Long> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <T> UnaryOperator<T> asUnaryOperator(Function<T, T> function) {
        return (arg0) -> function.apply(arg0);
    }

    static <T> BinaryOperator<T> asBinaryOperator(BiFunction<T, T, T> biFunction) {
        return (arg0, arg1) -> biFunction.apply(arg0, arg1);
    }

    static <T> BiFunction<T, T, T> asBiFunction(BinaryOperator<T> binaryOperator) {
        return (arg0, arg1) -> binaryOperator.apply(arg0, arg1);
    }

    static <T, U> BiPredicate<T, U> asBiPredicate(BiFunction<T, U, Boolean> biFunction) {
        return (arg0, arg1) -> biFunction.apply(arg0, arg1);
    }

    static <T, U> BiFunction<T, U, Boolean> asBiFunction(BiPredicate<T, U> biPredicate) {
        return (arg0, arg1) -> biPredicate.test(arg0, arg1);
    }

    static DoubleBinaryOperator asDoubleBinaryOperator(BiFunction<Double, Double, Double> biFunction) {
        return (arg0, arg1) -> biFunction.apply(arg0, arg1);
    }

    static BiFunction<Double, Double, Double> asBiFunction(DoubleBinaryOperator doubleBinaryOperator) {
        return (arg0, arg1) -> doubleBinaryOperator.applyAsDouble(arg0.doubleValue(), arg1.doubleValue());
    }

    static IntBinaryOperator asIntBinaryOperator(BiFunction<Integer, Integer, Integer> biFunction) {
        return (arg0, arg1) -> biFunction.apply(arg0, arg1);
    }

    static BiFunction<Integer, Integer, Integer> asBiFunction(IntBinaryOperator doubleBinaryOperator) {
        return (arg0, arg1) -> doubleBinaryOperator.applyAsInt(arg0.intValue(), arg1.intValue());
    }

    static LongBinaryOperator asLongBinaryOperator(BiFunction<Long, Long, Long> biFunction) {
        return (arg0, arg1) -> biFunction.apply(arg0, arg1);
    }

    static BiFunction<Long, Long, Long> asBiFunction(LongBinaryOperator longBinaryOperator) {
        return (arg0, arg1) -> longBinaryOperator.applyAsLong(arg0.longValue(), arg1.longValue());
    }

}
