package com.shermanpay.mex;

/**
 * Interface to all representation of numbers in MEx
 * Numbers in MEx are Wrapper objects for Java primitives
 * Has methods to obtain primitive values of Wrapper objects
 * and methods to obtain Wrapper objects
 * @author Sherman Pay Jing Hao
 * @version 0.1
 */
public interface MNumber extends MElement {
    public int intValue();
    public double decValue();
    public MInteger intEval();
}

