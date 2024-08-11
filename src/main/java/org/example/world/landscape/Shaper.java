package org.example.world.landscape;

import net.minestom.server.instance.generator.GenerationUnit;
import org.example.world.UnitData;

public abstract class Shaper
{
    protected GenerationUnit generationUnit;

    public Shaper()
    {
    }

    public abstract UnitData Shape(GenerationUnit generationUnit, UnitData unitData);
}
