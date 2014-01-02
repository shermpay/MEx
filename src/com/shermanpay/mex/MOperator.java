package com.shermanpay.mex;

public interface MOperator extends MElement {
    public MInteger intEval(MNumber x, MNumber y);
    public MInteger intEval(int x, int y);
}
