package com.shermanpay.mex;

/**
 * Class Containing all operators
 * @author Sherman Pay Jing Hao
 * @version 0.1
 */
public class MOperators {
    public static final MAdd ADD = new MAdd();
    public static final MSubtract SUBTRACT = new MSubtract();
    public static final MMultiply MULTIPLY = new MMultiply();
    public static final MDivide DIVIDE = new MDivide();
    
    /**
     * Gets the operator given String representation of operators
     * @param opString - String representation of operator
     * @return Constant MOperator object
     */
    public static MOperator getOperator(String opString) {
	switch (opString) {
	    case "+":
		return ADD;
	    case "-":
		return SUBTRACT;		
	    case "*":
		return MULTIPLY;
	    case "/":
		return DIVIDE;
	    default:
		return null;
	}
    }

    /**
     * Add operator class
     */
    private static class MAdd implements MOperator {
	public static final String string = "+";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x + y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() + y.intValue());
	}
    
	public boolean hasPrecedence() {
	    return false;
	}

	public String toString() {
	    return string;
	}
    }
    
    /**
     * Subtract operator class
     */
    private static class MSubtract implements MOperator {
	public static final String string = "-";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x - y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() - y.intValue());
	}

	public boolean hasPrecedence() {
	    return false;
	}

	public String toString() {
	    return string;
	}
    }

    /**
     * Multiply operator class
     */
    private static class MMultiply implements MOperator {
	public static final String string = "*";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x * y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() * y.intValue());
	}

	public boolean hasPrecedence() {
	    return true;
	}

	public String toString() {
	    return string;
	}
    }

    /**
     * Divide operator class
     */
    private static class MDivide implements MOperator {
	public static final String string = "/";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x / y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() / y.intValue());
	}

	public boolean hasPrecedence() {
	    return true;
	}

	public String toString() {
	    return string;
	}
    }

}
