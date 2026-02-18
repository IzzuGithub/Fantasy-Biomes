package com.fantasydimensions.datagen;

import com.fantasydimensions.FantasyDimensions;
import com.fantasydimensions.worldgen.ModBiomes;
import com.fantasydimensions.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.gen.GenerationStep;

import java.util.concurrent.CompletableFuture;

public class FantasyWorldGenerator extends FabricDynamicRegistryProvider {
    public FantasyWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.BIOME));
    }

    @Override
    public String getName() {
        return FantasyDimensions.MOD_ID;
    }
}