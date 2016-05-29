package compiler;

import java.util.Optional;

/**
 * Created by patrycja on 25.05.16.
 */
public class Token {

    public enum TokenType{
        OPPAREN,
        CLPAREN,
        EOF,
        NUMBER,
        ADD,
        MULT
    }

    private final TokenType tokenType;
    private final Optional<String> value;

    public Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = Optional.of(value);
    }

    public Token(TokenType tokenType){
        this.tokenType=tokenType;
        this.value=Optional.empty();
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public Optional<String> getValue() {
        return value;
    }

    @Override
    public String toString(){
        if (value.isPresent())
            return "{" + tokenType + ", " + value.get() +"}";
        else
            return "{" + tokenType +"}";
    }

}
