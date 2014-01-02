package com.shermanpay.mex;

public class MInteger implements MNumber, MOperator{
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

    public MInteger intEval(int x, int y) {
	return new MInteger(value);
    }

    public MInteger intEval(MNumber x, MNumber y) {
	return new MInteger(value);
    }


    public String toString() {
	return Integer.toString(value);
    }
}
