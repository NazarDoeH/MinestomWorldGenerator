package org.example.Commands;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;

public class Command_GameMode extends Command
{
    public Command_GameMode(InstanceContainer instance)
    {
        super("gamemode");

        setDefaultExecutor((sender, context) -> {
            sender.sendMessage("You executed the command");
        });

        var gameModeArgument = ArgumentType.Enum("gamemode", GameMode.class);

        addSyntax((sender, context) -> {
            GameMode gameMode = context.get(gameModeArgument);

            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                player.setGameMode(gameMode);
            }

        }, gameModeArgument);

    }
}