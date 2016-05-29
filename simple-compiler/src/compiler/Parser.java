package compiler;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by patrycja on 25.05.16.
 */
public class Parser {
    //private compiler.Token.TokenType getNextTokenType()

    private List<Token> tokens;
    private int lastTokenIndex;

    public Parser(List<Token> tokens){
        this.tokens=tokens;
        this.lastTokenIndex=0;
    }

    private Token getNextToken(){
        Token result = tokens.get(lastTokenIndex);
        if(lastTokenIndex<tokens.size()-1)
            lastTokenIndex++;
        return result;
    }

    private void restoreLastToken(){
            lastTokenIndex--;

    }

    public ParserTreeNode parseTerm(){
        Token nextToken = getNextToken();
        ParserTreeNode rootNode = null;
        if (nextToken.getTokenType()!= Token.TokenType.EOF) {
            rootNode = new ParserTreeNode(nextToken);
        }
        return rootNode;

    }

    public ParserTreeNode parseAdd(){
        ParserTreeNode rootNode = parseMult();
        Token nextToken = getNextToken();
        if (nextToken.getTokenType()!= Token.TokenType.EOF){

            while(nextToken.getTokenType()== Token.TokenType.ADD){
                ParserTreeNode newRootNode = new ParserTreeNode(nextToken);
                newRootNode.setLeftTree(rootNode);
                newRootNode.setRightTree(parseMult());
                rootNode=newRootNode;
                nextToken = getNextToken();
            }

            restoreLastToken();
        }

        return rootNode;
    }


    public ParserTreeNode parseMult(){
        ParserTreeNode rootNode = parseTerm();
        Token nextToken = getNextToken();
        if(nextToken.getTokenType()!= Token.TokenType.EOF) {
            while (nextToken.getTokenType() == Token.TokenType.MULT) {
                ParserTreeNode newRootNode = new ParserTreeNode(nextToken);
                newRootNode.setLeftTree(rootNode);
                newRootNode.setRightTree(parseTerm());
                rootNode = newRootNode;
                nextToken = getNextToken();
            }
            restoreLastToken();
        }
        return rootNode;
    }

}
