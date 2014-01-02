package com.shermanpay.mex;

import java.util.*;
import java.io.*;
public class Repl {
    private static final Console console = System.console();
    private static final String PROMPT = ":=:> ";
    public static void main(String[] args) {
	intro();
	String input = read();	
	while (input != null) {	    
	    print(eval(input));
	    input = read();
	}
    }

    public static void intro() {
	System.out.println("Welcome to MEx");
    }

    public static String read() {
	return console.readLine(PROMPT);
    }

    public static MNumber eval(String input) {
	Queue<Token> tokens = Lexer.tokenize(input);
	MExpression expr = new MExpression(tokens);
	return expr.evaluate();
    }

    public static void print(Object o) {
	System.out.println(o);
    }
}
