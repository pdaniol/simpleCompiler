package com.company;

import com.company.commands.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebo on 2016-05-24.
 */
public class CommandExecutor {

    private boolean isReading;

    private LinkedList<Integer> valuesStack;
    private List<Command> commands;

    public CommandExecutor() {
        this.valuesStack = new LinkedList<>();
        this.commands = new ArrayList<>();

        this.isReading = true;
    }

    public void parseInput(String input) {
        String[] splitInput = input.toLowerCase().split(" ");

        switch (splitInput[0]) {
            case "put":
                commands.add(new PutCommand(Integer.valueOf(splitInput[1]), valuesStack));
                break;
            case "add":
                commands.add(new AddCommand(valuesStack));
                break;
            case "mul":
                commands.add(new MulCommand(valuesStack));
                break;
            case "end":
                finish();
                break;
            default:
                isReading = false;
                return;
        }
    }

    private void finish() {
        EndCommand endCommand = new EndCommand(commands);
        endCommand.execute();

        isReading = false;
    }

    public Integer getResult() {
        if (valuesStack.size() == 1) {
            return valuesStack.peekFirst();
        }

        return null;
    }

    public boolean isReading() {
        return isReading;
    }
}
