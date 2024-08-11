package org.example.world;

import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;

import org.example.world.landscape.ShapeHeight;
import org.example.world.landscape.ShapePaint;
import org.jetbrains.annotations.NotNull;

import org.example.world.landscape.Shaper;

import java.util.ArrayList;
import java.util.List;

public class LandscapeStage implements Generator
{
    int seed = 0;

    private List<Shaper> shapers = new ArrayList<>();

    public LandscapeStage(int seed) {
        this.seed = seed;

        shapers.add(0, new ShapeHeight(1));
        shapers.add(1, new ShapePaint(4));
    }

    @Override
    public void generate(@NotNull GenerationUnit generationUnit) {
        final Point start = generationUnit.absoluteStart();
        final Point size = generationUnit.size();

        for (int x = 0; x < size.blockX(); x++) {
            for (int z = 0; z < size.blockZ(); z++) {

                UnitData unitData = new UnitData(start.add(x, 0, z));

                for (Shaper step : shapers) {
                    unitData = step.Shape(generationUnit, unitData);
                }
            }
        }
    }
}
