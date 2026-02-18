package com.fantasydimensions.worldgen;

import com.fantasydimensions.FantasyDimensions;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class FantasyTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new FantasyRegion(FantasyDimensions.id("overworld"), 5));
        FantasyDimensions.LOGGER.info("Registered Fantasy Dimensions TerraBlender region");
    }
}