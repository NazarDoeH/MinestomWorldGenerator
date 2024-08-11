package org.example.Commands;

import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.server.play.SetExperiencePacket;

public class Command_Kill extends Command
{
    public Command_Kill()
    {
        super("kill", "die");

        setDefaultExecutor((sender, context) -> {
            sender.sendMessage("You executed the command");
        });

        addSyntax((sender, context) -> {
            sender.sendMessage("You has been killed by the server");
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                player.kill();
                player.sendPacket(new SetExperiencePacket(50, 1, 0));
            }
        });

    }
}
