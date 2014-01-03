package com.shermanpay.mex;

import java.util.*;
import java.io.*;

/**
 * Read Eval Print Loop for MEx language
 * @author Sherman Pay Jing Hao
 * @version 0.1
 */
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

    /**
     * Outputs intro message to console
     */
    public static void intro() {
	System.out.println("Welcome to MEx");
    }

    /**
     * Reads user input from the console
     * @return user input as a String
     */
    public static String read() {
	return console.readLine(PROMPT);
    }

    /**
     * Evaluates user input and returns a MNumber
     * @param input - String representing user input
     * @return result of evaluation as MNumber
     */
    public static MNumber eval(String input) {
	Queue<Token> tokens = Lexer.tokenize(input);
	MExpression expr = new MExpression(tokens);
	
	return expr.evaluate();
    }

    /**
     * Prints the Object to the console
     * @param object - Object to print(result from eval)
     */
    public static void print(Object object) {
	System.out.println(object);
    }
}
