package com.fantasydimensions.worldgen;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class FantasyRegion extends Region {
    public FantasyRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            builder.replaceBiome(net.minecraft.world.biome.BiomeKeys.PLAINS, ModBiomes.PRIDE_BIOME);
            builder.replaceBiome(net.minecraft.world.biome.BiomeKeys.SWAMP, ModBiomes.FEAR_BIOME);
            builder.replaceBiome(net.minecraft.world.biome.BiomeKeys.DESERT, ModBiomes.MADNESS_BIOME);
            builder.replaceBiome(net.minecraft.world.biome.BiomeKeys.BADLANDS, ModBiomes.ANGER_BIOME);
            builder.replaceBiome(net.minecraft.world.biome.BiomeKeys.OCEAN, ModBiomes.SADNESS_BIOME);
            
            addBiome(mapper, 
                ParameterUtils.Temperature.WARM,
                ParameterUtils.Humidity.NEUTRAL,
                ParameterUtils.Continentalness.MID_INLAND,
                ParameterUtils.Erosion.EROSION_0,
                ParameterUtils.Weirdness.HIGH_SLICE_NORMAL_ASCENDING,
                ParameterUtils.Depth.SURFACE,
                0.0F,
                ModBiomes.PRIDE_BIOME);
            
            addBiome(mapper,
                ParameterUtils.Temperature.COOL,
                ParameterUtils.Humidity.HUMID,
                ParameterUtils.Continentalness.INLAND,
                ParameterUtils.Erosion.EROSION_6,
                ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING,
                ParameterUtils.Depth.SURFACE,
                0.0F,
                ModBiomes.FEAR_BIOME);
            
            addBiome(mapper,
                ParameterUtils.Temperature.HOT,
                ParameterUtils.Humidity.ARID,
                ParameterUtils.Continentalness.MID_INLAND,
                ParameterUtils.Erosion.EROSION_2,
                ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING,
                ParameterUtils.Depth.SURFACE,
                0.0F,
                ModBiomes.MADNESS_BIOME);
            
            addBiome(mapper,
                ParameterUtils.Temperature.HOT,
                ParameterUtils.Humidity.NEUTRAL,
                ParameterUtils.Continentalness.MID_INLAND,
                ParameterUtils.Erosion.EROSION_1,
                ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_ASCENDING,
                ParameterUtils.Depth.SURFACE,
                0.0F,
                ModBiomes.ANGER_BIOME);
            
            addBiome(mapper,
                ParameterUtils.Temperature.COOL,
                ParameterUtils.Humidity.HUMID,
                ParameterUtils.Continentalness.COAST,
                ParameterUtils.Erosion.EROSION_0,
                ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING,
                ParameterUtils.Depth.SURFACE,
                0.0F,
                ModBiomes.SADNESS_BIOME);
        });
    }
}