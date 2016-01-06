package com.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Generic class to copy values of object from one another.
 */
public class ValueCopier<S, D> {

    /**
     * Method to copy values from the source list of objects to the destination
     * list of objects
     *
     * @param source
     * @param mapper
     * @return List<D>
     */
    public List<D> copyValuesFromObjectList(List<S> source, Function<S, D> mapper) {
        return source != null ? source.stream()
                .map(mapper)
                .collect(Collectors.<D>toList()) : null;
    }

    /**
     * Method to copy values from one object to another object
     *
     * @param source
     * @param mapper
     * @return D
     */
    public D copyValuesFromObject(S source, Function<S, D> mapper) {
        return mapper != null ? mapper.apply(source) : null;
    }
}
