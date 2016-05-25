/**
 * Created by patrycja on 25.05.16.
 */
public class ParserTreeNode {
    private ParserTreeNode leftTree = null;
    private ParserTreeNode rightTree= null;
    private Token token;

    @Override
    public String toString() {
        return "Node{" + "T:" + token +
                "L:" + leftTree +
                ", R:" + rightTree + "}";
    }

    public ParserTreeNode(Token token) {
        this.token = token;
    }

    public ParserTreeNode(ParserTreeNode leftTree, ParserTreeNode rightTree, Token token) {
        this.leftTree = leftTree;
        this.rightTree = rightTree;
        this.token = token;
    }

    public ParserTreeNode getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(ParserTreeNode leftTree) {
        this.leftTree = leftTree;
    }

    public ParserTreeNode getRightTree() {
        return rightTree;
    }

    public void setRightTree(ParserTreeNode rightTree) {
        this.rightTree = rightTree;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
