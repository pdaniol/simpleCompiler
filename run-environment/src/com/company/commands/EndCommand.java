package com.company.commands;

import java.util.List;

/**
 * Created by Sebo on 2016-05-24.
 */
public class EndCommand implements Command {

    private List<Command> commands;

    public EndCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }
}
