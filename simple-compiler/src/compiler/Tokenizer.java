package compiler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;


/**
 * Created by patrycja on 25.05.16.
 */
public final class Tokenizer {


    public static List<Token> findTokens(String source){
        List<Token> tokens = new ArrayList<Token>();

        String tempSource = source.replaceAll("(?<=[0-9])(?=[^0-9])", " ");
        tempSource= tempSource.replaceAll("(?<=[^0-9])(?=[0-9])", " ");

        String delims = "[ ]+";
        String[] values= tempSource.split(delims);


        for(String val:values){
            if(val.equals("+"))
                tokens.add(new Token(Token.TokenType.ADD, val));
            else if(val.equals(("*")))
                tokens.add(new Token(Token.TokenType.MULT, val));
            else {
                int number = Integer.parseInt(val);
                tokens.add(new Token(Token.TokenType.NUMBER, ""+number ));
            }
        }

         tokens.add(new Token(Token.TokenType.EOF));

        return tokens;
    }

    public static boolean checkInput(String source){
        for(char c: source.toCharArray()){
            if(!Character.isDigit(c) && !Character.isWhitespace(c) && !(c=='+'|| c=='*'))
                return false;
        }

        return true;

    }

    public static boolean checkTokens(List<Token> tokens){
        for(int i=0; i<(tokens.size()-1); i++)
            if(tokens.get(i).getTokenType()==tokens.get(i+1).getTokenType())
                return false;

        return true;
    }
}
