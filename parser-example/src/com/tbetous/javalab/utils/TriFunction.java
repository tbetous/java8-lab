package com.tbetous.javalab.utils;

@FunctionalInterface
public interface TriFunction<A, B, C, D> {
    public D apply(A a, B b, C c);
}
