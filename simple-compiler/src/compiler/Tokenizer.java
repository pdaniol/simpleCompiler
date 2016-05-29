package compiler;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by patrycja on 25.05.16.
 */
public final class Tokenizer {

    private static final Character[] CHARACTERS = {'+', '*', '(', ')'};

    public static List<Token> findTokens(String source){
        List<Token> tokens = new ArrayList<Token>();

        String tempSource = source.trim();
        tempSource = tempSource.replaceAll("(?<=[0-9])(?=[^0-9])", " ");
        tempSource = tempSource.replaceAll("(?<=[^0-9])(?=[0-9])", " ");

        String delims = "[ ]+";
        String[] values= tempSource.split(delims);

        for (String val:values) {
            switch (val) {
                case "+":
                    tokens.add(new Token(Token.TokenType.ADD, val));
                    break;
                case "*":
                    tokens.add(new Token(Token.TokenType.MULT, val));
                    break;
                case "(":
                    tokens.add(new Token(Token.TokenType.OPPAREN, val));
                    break;
                case ")":
                    tokens.add(new Token(Token.TokenType.CLPAREN, val));
                    break;
                default:
                    int number = Integer.parseInt(val);
                    tokens.add(new Token(Token.TokenType.NUMBER, "" + number));
            }
        }

        tokens.add(new Token(Token.TokenType.EOF));

        return tokens;
    }

    public static boolean checkInput(String source){
        for(char c: source.toCharArray()){
            if (!Character.isDigit(c) && !Character.isWhitespace(c) && !isOperatorAllowed(c))
                return false;
        }

        return true;
    }

    private static boolean isOperatorAllowed(Character c) {
        for (Character character : CHARACTERS) {
            if (character.equals(c))
                return true;
        }

        return false;
    }

    public static boolean checkTokens(List<Token> tokens){
        for (int i=0; i < (tokens.size() - 1); i++) {
            if (!canTokensBeNeighbors(tokens.get(i), tokens.get(i + 1)))
                return false;
        }

        if (isTokenOperator(tokens.get(0)) || isTokenOperator(tokens.get(tokens.size() - 1)))
            return false;

        return true;
    }

    private static boolean canTokensBeNeighbors(Token t1, Token t2) {
        if (t2.getTokenType() == Token.TokenType.EOF)
            return true;

        if (t1.getTokenType() == Token.TokenType.NUMBER && (isTokenOperator(t2) || isTokenParenthesis(t2)))
            return true;

        if (t2.getTokenType() == Token.TokenType.NUMBER && (isTokenOperator(t1) || isTokenParenthesis(t1)))
            return true;

        return false;
    }

    private static boolean isTokenOperator(Token token) {
        Token.TokenType type = token.getTokenType();

        return (type == Token.TokenType.ADD || type == Token.TokenType.MULT);
    }

    private static boolean isTokenParenthesis(Token token) {
        return token.getTokenType() == Token.TokenType.OPPAREN || token.getTokenType() == Token.TokenType.CLPAREN;
    }
}
