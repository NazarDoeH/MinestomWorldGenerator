package org.example.world;

import de.articdive.jnoise.generators.noisegen.opensimplex.SuperSimplexNoiseGenerator;
import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;
import org.jetbrains.annotations.NotNull;

public class DecorGrassStage implements Generator
{
    private final SuperSimplexNoiseGenerator noise;

    public DecorGrassStage(long seed) {
        this.noise = SuperSimplexNoiseGenerator.newBuilder().setSeed(seed).build();
    }

    @Override
    public void generate(@NotNull GenerationUnit generationUnit) {
        final Point start = generationUnit.absoluteStart();
        final Point size = generationUnit.size();
        for (double x = 0; x < size.blockX(); x++) {
            for (double z = 0; z < size.blockZ(); z++) {
                Point bottom = start.add(x, 0, z);
                double height = noise.evaluateNoise((x + start.blockX()) * 0.009, (z + start.blockZ()) * 0.009) * 50;
                generationUnit.modifier().setBlock(bottom.withY(height), Block.GRASS_BLOCK);
            }
        }
    }
}