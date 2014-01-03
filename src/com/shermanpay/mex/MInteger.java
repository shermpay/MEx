package com.shermanpay.mex;

public class MInteger implements MNumber {
    private int value;

    public MInteger() {
	value = 0;
    }

    public MInteger(int n) {
	value = n;
    }

    public int intValue() {
	return value;
    }

    public double decValue() {
	return (double)value;
    }

    public MInteger intEval() {
	return new MInteger(value);
    }

    public String toString() {
	return Integer.toString(value);
    }
}
