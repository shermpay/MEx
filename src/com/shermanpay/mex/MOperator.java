package com.shermanpay.mex;

/**
 * Interface for operators
 * Includes methods for evaluation of various types
 * And methods for operator precedence
 * @author Sherman Pay Jing Hao
 * @version 0.1
 */
public interface MOperator extends MElement {
    public MInteger intEval(MNumber x, MNumber y);
    public MInteger intEval(int x, int y);
    public boolean hasPrecedence();
}
