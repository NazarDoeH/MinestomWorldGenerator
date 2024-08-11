//package org.example;
//
//import net.minestom.server.particle.Particle;
//import net.minestom.server.registry.Registry;
//import net.minestom.server.world.biome.Biome;
//import net.minestom.server.world.biome.BiomeEffects;
//import net.minestom.server.world.biome.BiomeParticle;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//
//public class Biome_TNT extends Biome {
//
//    @Override
//    public float temperature() {
//        return 1;
//    }
//
//    @Override
//    public float downfall() {
//        return 1;
//    }
//
//    @Override
//    public @NotNull BiomeEffects effects() {
//        return new BiomeEffects(
//                14982126,
//                12592744,
//                4159204,
//                329011,
//                1,
//                1,
//                BiomeEffects.GrassColorModifier.NONE,
//                new BiomeParticle(
//                        0.5f,
//                        Particle.SNOWFLAKE),
//                new BiomeEffects.AmbientSound(null),
//                new BiomeEffects.MoodSound(
//                        null,
//                        0,
//                        0,
//                        0),
//
//                new BiomeEffects.AdditionsSound(
//                        null,
//                        0),
//                new BiomeEffects.Music(
//                        null,
//                        0,
//                        0,
//                        false)
//
//                );
//    }
//
//    @Override
//    public @NotNull Precipitation precipitation() {
//        return Precipitation.RAIN;
//    }
//
//    @Override
//    public @NotNull TemperatureModifier temperatureModifier() {
//        return Biome.TemperatureModifier.NONE;
//    }
//
//    @Override
//    public Registry.@Nullable BiomeEntry registry() {
//        return null;
//    }
//
//}
