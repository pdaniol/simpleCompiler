package com.company.commands;

import java.util.LinkedList;

/**
 * Created by Sebo on 2016-05-24.
 */
public class AddCommand implements Command {

    private LinkedList<Integer> valuesStack;

    public AddCommand(LinkedList<Integer> valuesStack) {
        this.valuesStack = valuesStack;
    }

    @Override
    public void execute() {
        valuesStack.push(valuesStack.pop() + valuesStack.pop());
    }
}
