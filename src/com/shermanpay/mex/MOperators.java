package com.shermanpay.mex;

public class MOperators {
    public static final MPlus PLUS = new MPlus();
    public static final MMinus MINUS = new MMinus();
    
    public static MOperator getOperator(String opStr) {
	switch (opStr) {
	    case "+":
		return PLUS;
	    case "-":
		return MINUS;
	    default:
		return null;
	}
    }

    public static class MPlus implements MOperator {
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
    
    private static class MMinus implements MOperator {
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

}
