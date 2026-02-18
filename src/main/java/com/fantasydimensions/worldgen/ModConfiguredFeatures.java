package com.fantasydimensions.worldgen;

import com.fantasydimensions.FantasyDimensions;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PRIDE_TREE = registerKey("pride_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FEAR_TREE = registerKey("fear_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANGER_TREE = registerKey("anger_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOATING_ISLAND = registerKey("floating_island");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRATER = registerKey("crater");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LAVA_LAKE = registerKey("lava_lake");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POISON_LAKE = registerKey("poison_lake");

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, FantasyDimensions.id(name));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, PRIDE_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.ACACIA_LOG),
            new ForkingTrunkPlacer(8, 4, 4),
            BlockStateProvider.of(Blocks.ORANGE_WOOL),
            new AcaciaFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2)),
            new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());

        register(context, FEAR_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.DARK_OAK_LOG),
            new StraightTrunkPlacer(12, 8, 6),
            BlockStateProvider.of(Blocks.AIR),
            new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
            new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, ANGER_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.CRIMSON_STEM),
            new StraightTrunkPlacer(8, 4, 2),
            BlockStateProvider.of(Blocks.AIR),
            new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
            new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        register(context, FLOATING_ISLAND, Feature.ORE, new OreFeatureConfig(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            Blocks.STONE.getDefaultState(),
            64
        ));

        register(context, CRATER, Feature.DISK, new DiskFeatureConfig(
            RuleTest.ALWAYS_TRUE,
            BlockStateProvider.of(Blocks.AIR),
            UniformIntProvider.create(4, 8),
            3
        ));

        register(context, LAVA_LAKE, Feature.LAKE, new LakeFeature.Config(
            BlockStateProvider.of(Blocks.LAVA),
            BlockStateProvider.of(Blocks.BASALT)
        ));

        register(context, POISON_LAKE, Feature.LAKE, new LakeFeature.Config(
            BlockStateProvider.of(Blocks.WATER),
            BlockStateProvider.of(Blocks.SAND)
        ));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
        Registerable<ConfiguredFeature<?, ?>> context,
        RegistryKey<ConfiguredFeature<?, ?>> key,
        F feature,
        FC config
    ) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }

    public static void initialize() {
        FantasyDimensions.LOGGER.info("Registering Fantasy Dimensions configured features");
    }
}