package com.fantasydimensions.worldgen;

import com.fantasydimensions.FantasyDimensions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> PRIDE_BIOME = register("pride_biome");
    public static final RegistryKey<Biome> FEAR_BIOME = register("fear_biome");
    public static final RegistryKey<Biome> MADNESS_BIOME = register("madness_biome");
    public static final RegistryKey<Biome> ANGER_BIOME = register("anger_biome");
    public static final RegistryKey<Biome> SADNESS_BIOME = register("sadness_biome");

    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, FantasyDimensions.id(name));
    }

    public static void initialize() {
        FantasyDimensions.LOGGER.info("Registering Fantasy Dimensions biomes");
    }
}