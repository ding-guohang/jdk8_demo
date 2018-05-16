package com.dgh.process;

/**
 * @author dingguohang on 2018/5/14
 */
public interface ProcessorBuilder<C, T, R> {

    /**
     * build process chain by {@code processor.andThen}
     *
     * @param context context for processor builder
     * @see Processor#andThen
     */
    Processor<T, R> buildProcessorChain(C context);

    KeyEnum getKey();
}
