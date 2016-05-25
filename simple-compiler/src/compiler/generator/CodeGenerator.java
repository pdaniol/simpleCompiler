package compiler.generator;

import compiler.ParserTreeNode;
import compiler.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sebo on 2016-05-25.
 */
public class CodeGenerator {

    public List<Operation> parseSyntacticTree(ParserTreeNode root) {
        String treeAsString = getNodeValue(root);

        return generateOperationsList(treeAsString.trim());
    }

    private String getNodeValue(ParserTreeNode node) {
        StringBuilder builder = new StringBuilder();

        if (node.getLeftTree() != null) {
            builder.append(getNodeValue(node.getLeftTree()));
        }

        if (node.getRightTree() != null) {
            builder.append(getNodeValue(node.getRightTree()));
        }

        builder.append(parseToken(node.getToken()));
        builder.append(" ");

        return builder.toString();
    }

    private String parseToken(Token token) {
        switch (token.getTokenType()) {
            case ADD:
                return "+";
            case MULT:
                return "*";
            case NUMBER:
                Optional<String> value = token.getValue();
                if (value.isPresent()) {
                    return value.get();
                }
            default:
                return "";
        }
    }

    private List<Operation> generateOperationsList(String input) {
        List<Operation> result = new ArrayList<>();

        String[] splitInput = input.split(" ");
        for (String s : splitInput) {
            result.add(parseOperation(s));
        }
        result.add(new Operation(Operation.OperationType.end));

        return result;
    }

    private Operation parseOperation(String value) {
        switch (value) {
            case "+":
                return new Operation(Operation.OperationType.add);
            case "*":
                return new Operation(Operation.OperationType.mul);
            default:
                return new Operation(Operation.OperationType.put, value);
        }
    }
}
