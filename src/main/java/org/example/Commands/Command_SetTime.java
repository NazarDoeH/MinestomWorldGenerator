package org.example.Commands;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.instance.InstanceContainer;

public class Command_SetTime extends Command
{
     public Command_SetTime(InstanceContainer instance)
    {
        super("time");

        setDefaultExecutor((sender, context) -> {
            sender.sendMessage("You executed the command");
        });

        var timeArgument = ArgumentType.Integer("my-number");

        addSyntax((sender, context) -> {
            instance.setTime(context.get(timeArgument));
            sender.sendMessage("Time set to " + instance.getTime());
        }, timeArgument);

    }
}