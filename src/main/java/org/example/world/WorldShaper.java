package org.example.world;

import net.minestom.server.instance.generator.GenerationUnit;
import net.minestom.server.instance.generator.Generator;

import java.util.List;
import java.util.ArrayList;

public class WorldShaper {
    private List<Generator> stages = new ArrayList<>();

    public void AddStage(Generator stage) {
        stages.add(stage);
    }

    public void Generate(GenerationUnit generationUnit) {
        for (Generator stage : stages) {
            stage.generate(generationUnit);
        }
    }
}