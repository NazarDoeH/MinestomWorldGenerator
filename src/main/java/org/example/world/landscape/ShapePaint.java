package org.example.world.landscape;

import net.minestom.server.instance.block.Block;
import net.minestom.server.instance.generator.GenerationUnit;

import org.example.world.UnitData;

public class ShapePaint extends Shaper {

    private int grassLayerHeight = 4;

    public ShapePaint(int grassLayerHeight)
    {
        this.grassLayerHeight = grassLayerHeight;
    }

    public UnitData Shape(GenerationUnit generationUnit, UnitData unitData)
    {
        for(int y = -64; y <= unitData.height; y++)
        {
            if (y < unitData.height && y >= -64)
            {
                if (y >= unitData.height - 1)
                {
                    generationUnit.modifier().setBlock(
                            unitData.position.blockX(),
                            y,
                            unitData.position.blockZ(),
                            Block.GRASS_BLOCK);
                }
                else if(y >= unitData.height - grassLayerHeight)
                {
                    generationUnit.modifier().setBlock(
                            unitData.position.blockX(),
                            y,
                            unitData.position.blockZ(),
                            Block.DIRT);
                }
                else
                {
                    generationUnit.modifier().setBlock(
                            unitData.position.blockX(),
                            y,
                            unitData.position.blockZ(),
                            Block.STONE);
                }
            }
        }
        return unitData;
    }
}