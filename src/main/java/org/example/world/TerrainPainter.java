package org.example.world;

import net.minestom.server.instance.block.Block;

public class TerrainPainter
{
    public int dirtLayerDepth = 1;

    public TerrainPainter(int dirtLayerDepth)
    {
        this.dirtLayerDepth = dirtLayerDepth;
    }

    public Block GetBlock(int blockHeight, int terrainHeight)
    {
        Block block = Block.TNT;

        if (blockHeight == terrainHeight && dirtLayerDepth != 0)
        {
            block = Block.GRASS_BLOCK;
        }
        else if (blockHeight > terrainHeight && terrainHeight - blockHeight < dirtLayerDepth)
        {
            block = Block.DIRT;
        }
        return block;
    }
}
