package org.example.world.landscape;

import de.articdive.jnoise.core.api.functions.Combiner;
import de.articdive.jnoise.core.api.functions.Interpolation;
import de.articdive.jnoise.generators.noise_parameters.distance_functions.DistanceFunction;
import de.articdive.jnoise.generators.noise_parameters.distance_functions.DistanceFunctionType;
import de.articdive.jnoise.generators.noise_parameters.fade_functions.FadeFunction;
import de.articdive.jnoise.generators.noise_parameters.simplex_variants.Simplex2DVariant;
import de.articdive.jnoise.generators.noise_parameters.simplex_variants.Simplex3DVariant;
import de.articdive.jnoise.generators.noise_parameters.simplex_variants.Simplex4DVariant;
import de.articdive.jnoise.generators.noisegen.opensimplex.FastSimplexNoiseGenerator;
import de.articdive.jnoise.generators.noisegen.opensimplex.SuperSimplexNoiseGenerator;
import de.articdive.jnoise.generators.noisegen.random.white.WhiteNoiseGenerator;
import de.articdive.jnoise.generators.noisegen.worley.WorleyNoiseGenerator;
import de.articdive.jnoise.modules.blend.BlendModule;
import de.articdive.jnoise.modules.combination.CombinationModule;
import de.articdive.jnoise.modules.octavation.OctavationModule;
import de.articdive.jnoise.pipeline.JNoise;
import net.minestom.server.instance.generator.GenerationUnit;

import org.example.world.UnitData;

import java.util.function.IntToLongFunction;

public class ShapeHeight extends Shaper {

    private final JNoise noisee = JNoise.newBuilder().fastSimplex(1, Simplex2DVariant.CLASSIC, Simplex3DVariant.CLASSIC, Simplex4DVariant.CLASSIC).build();

    public ShapeHeight(long seed)
    {

        //this.noise = SuperSimplexNoiseGenerator.newBuilder().setSeed(seed).build();
    }

    public UnitData Shape(GenerationUnit generationUnit, UnitData unitData)
    {
        synchronized (noisee)
        {
            unitData.height = (int) (noisee.evaluateNoise(unitData.position.x(), unitData.position.z()) * 50);
            return unitData;
        }
    }
}
