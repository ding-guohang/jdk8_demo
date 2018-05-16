package com.dgh.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author dingguohang on 2018/5/14
 */
public class ProcessorFactory {

    private Map<KeyEnum, ProcessorBuilder> builders = new HashMap<>();
    // processChain for every key
    private Map<KeyEnum, Processor> processorChains = new ConcurrentHashMap<>();

    @Resource
    private List<ProcessorBuilder> list;

    @PostConstruct
    public void init() {
        list.forEach(e -> builders.put(e.getKey(), e));
    }

    @SuppressWarnings("unchecked")
    public <T, B, R> Processor<T, R> getChain(KeyEnum portal, B context) {
        if (processorChains.containsKey(portal)) {
            return processorChains.get(portal);
        }

        Processor<T, R> ret = builders.get(portal).buildProcessorChain(context);
        ret = processorChains.putIfAbsent(portal, ret);
        return ret;
    }
}
