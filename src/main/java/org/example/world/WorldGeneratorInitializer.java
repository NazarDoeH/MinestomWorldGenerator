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
        WorldShaper worldShaper = new WorldShaper();

        worldShaper.AddStage(new LandscapeHeightStage(1));
        worldShaper.AddStage(new DecorGrassStage(1));

        return new Generator()
        {
            @Override
            public void generate(@NotNull GenerationUnit generationUnit)
            {
                worldShaper.Generate(generationUnit);
            }
        };
    }
}
