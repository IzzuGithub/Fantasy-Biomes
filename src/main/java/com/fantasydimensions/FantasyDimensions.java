package com.fantasydimensions;

import com.fantasydimensions.worldgen.ModBiomes;
import com.fantasydimensions.worldgen.ModConfiguredFeatures;
import com.fantasydimensions.worldgen.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FantasyDimensions implements ModInitializer {
    public static final String MOD_ID = "fantasydimensions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Fantasy Dimensions Worldgen");
        
        ModConfiguredFeatures.initialize();
        ModPlacedFeatures.initialize();
        ModBiomes.initialize();
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}