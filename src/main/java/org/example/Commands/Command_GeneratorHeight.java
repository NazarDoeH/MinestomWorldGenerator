package org.example.Commands;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.block.Block;

public class Command_GeneratorHeight extends Command
{
    public Command_GeneratorHeight(InstanceContainer instance)
    {
        super("worldHeight");

        setDefaultExecutor((sender, context) -> {
            sender.sendMessage("You executed the command");
        });

        var heightArgument = ArgumentType.Integer("my-number");

        addSyntax((sender, context) -> {
            Block tnt = Block.TNT.withProperty("unstable", "true");

            int height = context.get(heightArgument);

            instance.setGenerator(unit -> unit.modifier().fillHeight(0, height, tnt));
        }, heightArgument);

    }
}