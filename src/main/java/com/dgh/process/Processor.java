package com.dgh.process;

import java.util.Objects;

/**
 * @author dingguohang on 2018/5/15
 */
public interface Processor<T, R> {

    /**
     * Process this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R process(T t);

    /**
     * Returns a composed processor that first applies the {@code before}
     * processor to its input, and then applies this processor to the result.
     * If evaluation of either processor throws an exception, it is relayed to
     * the caller of the composed processor.
     *
     * @param <V>    the type of input to the {@code before} processor, and to the
     *               composed processor
     * @param before the processor to apply before this processor is applied
     * @return a composed function that first applies the {@code before}
     * processor and then applies this processor
     * @throws NullPointerException if before is null
     * @see #andThen(Processor)
     */
    default <V> Processor<T, V> andThen(Processor<? super R, ? extends V> before) {
        Objects.requireNonNull(before);
        return (T t) -> before.process(process(t));
    }
}
