package com.shermanpay.mex;

/**
 * Token class to define rules for all tokens
 * Used for lexical analysis
 * @author Sherman Pay Jing Hao
 * @version 0.1
 */
public class Token {
    public static enum TokenType {
	WHITESPACE("[ \t\n]"),
	BINARYOP("[\\*|\\+|/|-]"),
	NUMBER("-?[0-9]+");

	public final String pattern;

	private TokenType(String pattern) {
	    this.pattern = pattern;
	}
    }

    private TokenType type;
    private String data;

    public Token(TokenType type, String data) {
	this.type = type;
	this.data = data;
    }

    public TokenType type() {
	return this.type;
    }

    public String data() {
	return data;
    }

    public String toString() {
	return String.format("(%s, %s)", type.name(), data);
    }
}

