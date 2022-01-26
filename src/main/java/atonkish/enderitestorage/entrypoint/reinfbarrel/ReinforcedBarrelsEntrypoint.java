package atonkish.enderitestorage.entrypoint.reinfbarrel;

import atonkish.reinfcore.util.ReinforcingMaterial;
import atonkish.reinfbarrel.api.ReinforcedBarrelsModInitializer;
import atonkish.reinfbarrel.api.ReinforcedBarrelsRegistry;
import atonkish.enderitestorage.EnderiteReinforcedStorageMod;
import atonkish.enderitestorage.util.ReinforcingMaterialSettings;

public class ReinforcedBarrelsEntrypoint implements ReinforcedBarrelsModInitializer {
    @Override
    public void onInitializeReinforcedBarrels() {
        initializeReinforcedBarrels();
    }

    private static void initializeReinforcedBarrels() {
        for (ReinforcingMaterialSettings materialSettings : ReinforcingMaterialSettings.values()) {
            ReinforcingMaterial material = materialSettings.getMaterial();

            // Stats
            ReinforcedBarrelsRegistry.registerMaterialOpenStat(EnderiteReinforcedStorageMod.MOD_ID, material);

            // Blocks
            ReinforcedBarrelsRegistry.registerMaterialBlock(EnderiteReinforcedStorageMod.MOD_ID, material,
                    materialSettings.getBlockSettings());
            ReinforcedBarrelsRegistry.registerMaterialBlockEntityType(EnderiteReinforcedStorageMod.MOD_ID, material);

            // Items
            ReinforcedBarrelsRegistry.registerMaterialItem(
                    EnderiteReinforcedStorageMod.MOD_ID, material, materialSettings.getItemSettings());
        }
    }
}
