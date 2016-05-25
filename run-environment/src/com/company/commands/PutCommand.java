package com.company.commands;

import java.util.LinkedList;

/**
 * Created by Sebo on 2016-05-24.
 */
public class PutCommand implements Command {

    private int value;
    private LinkedList<Integer> valuesStack;

    public PutCommand(int value, LinkedList<Integer> valuesStack) {
        this.value = value;
        this.valuesStack = valuesStack;
    }

    @Override
    public void execute() {
        valuesStack.push(value);
    }
}
