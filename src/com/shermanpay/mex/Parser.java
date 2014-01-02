package com.shermanpay.mex;

import java.util.*;
public class Parser {
    
    public static MExpression buildExpressionTree(List<Token> tokens) {
	Stack<MElement> buffer = new Stack<MElement>();
	MExpression tree = new MExpression();
	
	for (int i = 1; i < tokens.size(); i+=2) {

	}
	return tree;
    }

}
