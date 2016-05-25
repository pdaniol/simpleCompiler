package com.company.commands;

import java.util.LinkedList;

/**
 * Created by Sebo on 2016-05-24.
 */
public class MulCommand implements Command {

    private LinkedList<Integer> valuesStack;

    public MulCommand(LinkedList<Integer> valuesStack) {
        this.valuesStack = valuesStack;
    }

    @Override
    public void execute() {
        valuesStack.push(valuesStack.pop() * valuesStack.pop());
    }
}
