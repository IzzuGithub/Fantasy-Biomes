package com.fantasydimensions.datagen;

import com.fantasydimensions.worldgen.ModBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FantasyBiomeData {
    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placedFeatures = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> carvers = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        context.register(ModBiomes.PRIDE_BIOME, createPrideBiome(placedFeatures, carvers));
        context.register(ModBiomes.FEAR_BIOME, createFearBiome(placedFeatures, carvers));
        context.register(ModBiomes.MADNESS_BIOME, createMadnessBiome(placedFeatures, carvers));
        context.register(ModBiomes.ANGER_BIOME, createAngerBiome(placedFeatures, carvers));
        context.register(ModBiomes.SADNESS_BIOME, createSadnessBiome(placedFeatures, carvers));
    }

    private static Biome createPrideBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> carvers) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 20, 1, 4));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SILVERFISH, 10, 2, 5));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.BREEZE, 5, 1, 2));

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(placedFeatures, carvers);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addPlainsTallGrass(generationSettings);
        
        return new Biome.Builder()
            .precipitation(true)
            .temperature(0.8F)
            .downfall(0.4F)
            .effects(new BiomeEffects.Builder()
                .skyColor(0xFF8C00)
                .fogColor(0xFFAA44)
                .waterColor(0x3F76E4)
                .waterFogColor(0x050533)
                .grassColor(0xD4A860)
                .foliageColor(0xE0A040)
                .moodSound(BiomeMoodSound.CAVE)
                .build())
            .spawnSettings(spawnSettings.build())
            .generationSettings(generationSettings.build())
            .build();
    }

    private static Biome createFearBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> carvers) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 25, 2, 4));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITHER_SKELETON, 15, 1, 3));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.Builder().build().getSpawnEntries(SpawnGroup.CREATURE));

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(placedFeatures, carvers);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addSwampFeatures(generationSettings);
        
        return new Biome.Builder()
            .precipitation(true)
            .temperature(0.5F)
            .downfall(0.9F)
            .effects(new BiomeEffects.Builder()
                .skyColor(0x4A148C)
                .fogColor(0x2E0854)
                .waterColor(0x1A1A1A)
                .waterFogColor(0x0A0A0A)
                .grassColor(0x3A3A3A)
                .foliageColor(0x2A2A2A)
                .moodSound(BiomeMoodSound.CAVE)
                .build())
            .spawnSettings(spawnSettings.build())
            .generationSettings(generationSettings.build())
            .build();
    }

    private static Biome createMadnessBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> carvers) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 15, 2, 5));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 10, 1, 2));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 20, 2, 4));

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(placedFeatures, carvers);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDesertDeadBushes(generationSettings);
        DefaultBiomeFeatures.addDesertVegetation(generationSettings);
        
        return new Biome.Builder()
            .precipitation(false)
            .temperature(2.0F)
            .downfall(0.0F)
            .effects(new BiomeEffects.Builder()
                .skyColor(0xD4C157)
                .fogColor(0xC9BC0F)
                .waterColor(0xD4D415)
                .waterFogColor(0xA0A010)
                .grassColor(0xB8A860)
                .foliageColor(0xA89850)
                .moodSound(BiomeMoodSound.CAVE)
                .build())
            .spawnSettings(spawnSettings.build())
            .generationSettings(generationSettings.build())
            .build();
    }

    private static Biome createAngerBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> carvers) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.BLAZE, 15, 1, 3));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 20, 2, 4));

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(placedFeatures, carvers);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addBadlandsGrass(generationSettings);
        
        return new Biome.Builder()
            .precipitation(false)
            .temperature(2.0F)
            .downfall(0.0F)
            .effects(new BiomeEffects.Builder()
                .skyColor(0xFF0000)
                .fogColor(0xCC0000)
                .waterColor(0xFF4500)
                .waterFogColor(0xCC3300)
                .grassColor(0x8B4513)
                .foliageColor(0x8B0000)
                .moodSound(BiomeMoodSound.CAVE)
                .build())
            .spawnSettings(spawnSettings.build())
            .generationSettings(generationSettings.build())
            .build();
    }

    private static Biome createSadnessBiome(RegistryEntryLookup<PlacedFeature> placedFeatures, RegistryEntryLookup<ConfiguredCarver<?>> carvers) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.DOLPHIN, 5, 1, 2));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 15, 2, 4));
        spawnSettings.spawn(SpawnGroup.UNDERGROUND_WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.AXOLOTL, 10, 1, 3));
        spawnSettings.spawn(SpawnGroup.UNDERGROUND_WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.GLOW_SQUID, 8, 2, 4));
        spawnSettings.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 25, 3, 8));

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(placedFeatures, carvers);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultSeagrassOnStone(generationSettings);
        DefaultBiomeFeatures.addDefaultKelp(generationSettings);
        DefaultBiomeFeatures.addLessKelp(generationSettings);
        
        return new Biome.Builder()
            .precipitation(true)
            .temperature(0.5F)
            .downfall(0.9F)
            .effects(new BiomeEffects.Builder()
                .skyColor(0x0D47A1)
                .fogColor(0x1565C0)
                .waterColor(0x0D47A1)
                .waterFogColor(0x0A3D8F)
                .grassColor(0x5D9D5D)
                .foliageColor(0x4A8B4A)
                .moodSound(BiomeMoodSound.CAVE)
                .build())
            .spawnSettings(spawnSettings.build())
            .generationSettings(generationSettings.build())
            .build();
    }
}