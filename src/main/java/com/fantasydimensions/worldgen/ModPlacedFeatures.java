package com.fantasydimensions.worldgen;

import com.fantasydimensions.FantasyDimensions;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> PRIDE_TREE_PLACED = registerKey("pride_tree_placed");
    public static final RegistryKey<PlacedFeature> FEAR_TREE_PLACED = registerKey("fear_tree_placed");
    public static final RegistryKey<PlacedFeature> ANGER_TREE_PLACED = registerKey("anger_tree_placed");
    public static final RegistryKey<PlacedFeature> FLOATING_ISLAND_PLACED = registerKey("floating_island_placed");
    public static final RegistryKey<PlacedFeature> CRATER_PLACED = registerKey("crater_placed");
    public static final RegistryKey<PlacedFeature> LAVA_LAKE_PLACED = registerKey("lava_lake_placed");
    public static final RegistryKey<PlacedFeature> POISON_LAKE_PLACED = registerKey("poison_lake_placed");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, FantasyDimensions.id(name));
    }

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PRIDE_TREE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.PRIDE_TREE),
            List.of(
                PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
            ));

        register(context, FEAR_TREE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.FEAR_TREE),
            List.of(
                PlacedFeatures.createCountExtraModifier(5, 0.5f, 2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
            ));

        register(context, ANGER_TREE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANGER_TREE),
            List.of(
                PlacedFeatures.createCountExtraModifier(3, 0.3f, 1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
            ));

        register(context, FLOATING_ISLAND_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOATING_ISLAND),
            List.of(
                RarityFilterPlacementModifier.of(20),
                SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(net.minecraft.util.math.intprovider.UniformIntProvider.create(100, 200)),
                BiomePlacementModifier.of()
            ));

        register(context, CRATER_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.CRATER),
            List.of(
                RarityFilterPlacementModifier.of(15),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
            ));

        register(context, LAVA_LAKE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.LAVA_LAKE),
            List.of(
                RarityFilterPlacementModifier.of(10),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
            ));

        register(context, POISON_LAKE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.POISON_LAKE),
            List.of(
                RarityFilterPlacementModifier.of(12),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
            ));
    }

    private static void register(
        Registerable<PlacedFeature> context,
        RegistryKey<PlacedFeature> key,
        RegistryEntry<ConfiguredFeature<?, ?>> config,
        List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    public static void initialize() {
        FantasyDimensions.LOGGER.info("Registering Fantasy Dimensions placed features");
    }
}