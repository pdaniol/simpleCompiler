package compiler.generator;

/**
 * Created by Sebo on 2016-05-25.
 */
public class Operation {

    public enum OperationType {
        put, add, mul, end
    }

    private OperationType operationType;
    private String argument;

    public Operation(OperationType operationType) {
        this.operationType = operationType;
    }

    public Operation(OperationType operationType, String argument) {
        this.operationType = operationType;
        this.argument = argument;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        if (argument != null) {
            return operationType + " " + argument;
        } else {
            return operationType.toString();
        }
    }
}
