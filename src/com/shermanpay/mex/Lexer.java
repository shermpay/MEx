package com.shermanpay.mex;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    public static List<Token> tokenize(String code) {
	List<Token> tokens = new ArrayList<Token>();
	
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

    public static Pattern buildTokenPattern() {
	StringBuilder patternBuilder = new StringBuilder();
	for (Token.TokenType type : Token.TokenType.values()) {
	    patternBuilder.append(String.format("|(?<%s>%s)",
						type.name(), type.pattern));
	}

	return Pattern.compile(new String(patternBuilder.substring(1)));
    }

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
