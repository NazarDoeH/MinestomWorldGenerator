package org.example.world;

import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;
import org.example.Main;
import org.jetbrains.annotations.NotNull;

public class WorldGeneratorInitializer
{
    InstanceContainer instanceContainer = Main.instanceContainer;

    public static Generator GetGenerator()
    {
        WorldModifier worldModifier = new WorldModifier();

        worldModifier.AddStage(new LandscapeStage(1));

        return new Generator()
        {
            @Override
            public void generate(@NotNull GenerationUnit generationUnit)
            {
                worldModifier.Generate(generationUnit);
            }
        };
    }
}
