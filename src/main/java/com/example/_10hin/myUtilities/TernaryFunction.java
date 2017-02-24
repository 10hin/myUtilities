package com.example._10hin.myUtilities;

/**
 * 3つの引数を受け取って結果を生成する関数を表します。これはFunctionを、引数を3つとるように
 * 特殊化したものです。
 * @author kei
 *
 * @param <T> 関数の第1引数の型
 * @param <U> 関数の第2引数の型
 * @param <V> 関数の第3引数の型
 * @param <R>
 */
public interface TernaryFunction<T, U, V, R> {

	R apply(T t, U u, V v);

}
