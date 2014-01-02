package com.shermanpay.mex;

import java.util.List;
public class MExpression {
    private MExpressionNode overallRoot;
    private int size;
    private MNumber overallValue;

    public MExpression() {}

    public MExpression(MExpressionNode root) {
	overallRoot = root;
	size = 1;
    }

    public MExpression(int left, MOperator op, int right) {
	overallRoot = new MExpressionNode(op);
	overallRoot.left = new MExpressionNode(left);
	overallRoot.right = new MExpressionNode(right);
	size = 1;
    }

    public MExpression(List<Token> tokens) {
	MExpressionNode left = new MExpressionNode(tokens.get(0).data());
	for (int i = 1; i < tokens.size(); i+=2) {
	    MOperator operator = MOperators.getOperator(tokens.get(i).data());
	    overallRoot =
		new MExpressionNode(left,
				    operator,
				    new MExpressionNode(tokens.get(i+1).data()));
	    left = overallRoot;
	}
    }

    public MNumber evaluate() {
	return evalHelper(overallRoot);
    }

    private MNumber evalHelper(MExpressionNode root) {
	if (root == null) {
	    return new MInteger(0);
	}

	MOperator op = (MOperator)root.element;
	MNumber left = evalHelper(root.left);
	MNumber right = evalHelper(root.right);
	return op.intEval(left, right);
    }

    public int size() {
	return size;
    }

    public String toString() {
	return toStringHelper(overallRoot);
    }

    private String toStringHelper(MExpressionNode root) {
	if (root == null) {
	    return "";
	} else {
	    return toStringHelper(root.left) + root.toString() +
		toStringHelper(root.right);
	}
    }

    public class MExpressionNode {
	public MExpressionNode left;
	public MExpressionNode right;
	public MElement element;
	
	public MExpressionNode(String intString) {
	    this.element = new MInteger(Integer.parseInt(intString));
	}

	public MExpressionNode(int num) {
	    this.element = new MInteger(num);
	}

	public MExpressionNode(MOperator op) {
	    this.element = op;
	}

	public MExpressionNode(MElement element) {
	    this.element = element;
	}

	public MExpressionNode(MExpressionNode left, MElement element,
			       MExpressionNode right) {
	    this.left = left;
	    this.element = element;
	    this.right = right;
	}

	public String toString () {
	    return element.toString(); 
	}
    }

}
