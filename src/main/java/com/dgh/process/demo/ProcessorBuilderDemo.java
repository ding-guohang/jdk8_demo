package com.dgh.process.demo;

import static com.dgh.process.KeyEnum.DEMO;

import com.dgh.process.KeyEnum;
import com.dgh.process.Processor;
import com.dgh.process.ProcessorBuilder;

/**
 * @author dingguohang on 2018/5/16
 */
public class ProcessorBuilderDemo implements ProcessorBuilder<String, String, Double> {

    @Override
    public Processor<String, Double> buildProcessorChain(String context) {
        return new IntegerProcessor().andThen(new DoubleProcessor());
    }

    @Override
    public KeyEnum getKey() {
        return DEMO;
    }

    private class IntegerProcessor implements Processor<String, Integer> {

        @Override
        public Integer process(String s) {
            Integer ret = Integer.valueOf(s) + 2;
            System.out.println("Class: " + getClass().getSimpleName() + ", input " + s + ", output " + ret);
            return ret;
        }
    }

    private class DoubleProcessor implements Processor<Integer, Double> {

        @Override
        public Double process(Integer s) {
            Double ret = Double.valueOf(s) + 2.1D;
            System.out.println("Class: " + getClass().getSimpleName() + ", input " + s + ", output " + ret);
            return ret;
        }
    }
}
