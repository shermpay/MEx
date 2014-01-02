package com.shermanpay.mex;

public class MOperators {
    public static final MAdd ADD = new MAdd();
    public static final MSubtract SUBTRACT = new MSubtract();
    public static final MMultiply MULTIPLY = new MMultiply();
    public static final MDivide DIVIDE = new MDivide();
    
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

    public static boolean hasPrecedence(String opString) {
	return opString.equals("*") || opString.equals("/");
    }

    private static class MAdd implements MOperator {
	public static final String string = "+";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x + y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() + y.intValue());
	}
    
	public String toString() {
	    return string;
	}
    }
    
    private static class MSubtract implements MOperator {
	public static final String string = "-";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x - y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() - y.intValue());
	}

	public String toString() {
	    return string;
	}
    }

    private static class MMultiply implements MOperator {
	public static final String string = "*";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x * y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() * y.intValue());
	}

	public String toString() {
	    return string;
	}
    }

    private static class MDivide implements MOperator {
	public static final String string = "/";

	public MInteger intEval(int x, int y) {
	    return new MInteger(x / y);
	}

	public MInteger intEval(MNumber x, MNumber y) {
	    return new MInteger(x.intValue() / y.intValue());
	}

	public String toString() {
	    return string;
	}
    }

}
