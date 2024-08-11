package org.example.world;

import de.articdive.jnoise.generators.noisegen.opensimplex.SuperSimplexNoiseGenerator;

import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;
import net.minestom.server.instance.block.Block;

import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class WorldGenerator
{
    static final SuperSimplexNoiseGenerator noise = SuperSimplexNoiseGenerator.newBuilder().setSeed(1).build();

    static Random rand = new Random();

    public static Generator GenerateWorld()
    {
        Generator generator = new Generator() {
            @Override
            public void generate(@NotNull GenerationUnit generationUnit) {
                final Point start = generationUnit.absoluteStart();
                final Point size = generationUnit.size();
                for (double x = 0; x < size.blockX(); x++) {
                    for (double z = 0; z < size.blockZ(); z++) {
                        Point bottom = start.add(x, 0, z);

                        synchronized (noise)
                        { // Synchronization is necessary for JNoise
                            double height = noise.evaluateNoise((x + start.blockX()) * 0.009, (z + start.blockZ()) * 0.009) * 50;

                            // * 16 means the height will be between -16 and +16
                            generationUnit.modifier().fill(bottom, bottom.add(1, 0, 1).withY(height), Block.TNT);
                        }
                    }
                }
            }
        };
        return generator;
    }
}
