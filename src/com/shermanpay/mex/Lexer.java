package com.shermanpay.mex;

import java.util.Queue;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for lexexical analysis of code to produce tokens
 * @author Sherman Pay Jing Hao
 * @version 0.1
 */

public class Lexer {
    
    /**
     * Builds a Queue of Token objects from the code 
     * given the rules defined in Token
     * @param code - String of MEx code
     * @return A Queue of Tokens
     */
    public static Queue<Token> tokenize(String code) {
	Queue<Token> tokens = new LinkedList<Token>();
	
	Pattern tokenPattern = buildTokenPattern();

	// Matching tokens
	Matcher matcher = tokenPattern.matcher(code);
	while (matcher.find()) {
	    Token token = getToken(matcher);
	    if (token != null) {
		tokens.add(token);
	    }
	}
	
	return tokens;
    }

    /**
     * Builds a Pattern object based on rules defined in Token
     * @return A Pattern Object of Token rules
     */
    public static Pattern buildTokenPattern() {
	StringBuilder patternBuilder = new StringBuilder();
	for (Token.TokenType type : Token.TokenType.values()) {
	    patternBuilder.append(String.format("|(?<%s>%s)",
						type.name(), type.pattern));
	}

	return Pattern.compile(new String(patternBuilder.substring(1)));
    }

    /**
     * Gets the next Token in matcher
     * @param matcher - Matcher object to find Token
     * @return The next Token object
     */
    public static Token getToken(Matcher matcher) {
	if (matcher.group(Token.TokenType.NUMBER.name()) != null) {
		return new Token(Token.TokenType.NUMBER,
				     matcher.group(Token.TokenType.NUMBER.name()));
	}
	if (matcher.group(Token.TokenType.BINARYOP.name()) != null) {
                return new Token(Token.TokenType.BINARYOP,
				 matcher.group(Token.TokenType.BINARYOP.name()));
	}
	return null;
    }
}
