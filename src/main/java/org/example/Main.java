package org.example;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.*;
import net.minestom.server.instance.block.Block;
import net.minestom.server.coordinate.Pos;

import org.example.Commands.Command_Kill;
import org.example.Commands.Command_SetTime;
import org.example.Commands.Command_GeneratorHeight;
import org.example.Commands.Command_GameMode;
import org.example.world.WorldGenerator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();


        // Initialization
        MinecraftServer minecraftServer = MinecraftServer.init();

        // Create the instance
        InstanceManager instanceManager = MinecraftServer.getInstanceManager();

        InstanceContainer instanceContainer = instanceManager.createInstanceContainer();

        instanceContainer.setChunkSupplier(LightingChunk::new);


        minecraftServer.getCommandManager().register(new Command_Kill());
        minecraftServer.getCommandManager().register(new Command_SetTime(instanceContainer));
        minecraftServer.getCommandManager().register(new Command_GeneratorHeight(instanceContainer));
        minecraftServer.getCommandManager().register(new Command_GameMode(instanceContainer));




        // Set the ChunkGenerator
        Block tnt = Block.TNT.withProperty("unstable", "true");
        instanceContainer.setGenerator(WorldGenerator.GenerateWorld());

        // Add an event callback to specify the spawning instance (and the spawn position)
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();

        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            final Player player = event.getPlayer();
            event.setSpawningInstance(instanceContainer);
            player.setRespawnPoint(new Pos(0, 42, 0));
            player.setGameMode(GameMode.CREATIVE);
        });

        // Start the server on port 25565
        minecraftServer.start("0.0.0.0", 25565);
    }
};
