package atonkish.enderitestorage.entrypoint.reinfchest;

import atonkish.reinfcore.util.ReinforcingMaterial;
import atonkish.reinfchest.api.ReinforcedChestsModInitializer;
import atonkish.reinfchest.api.ReinforcedChestsRegistry;
import atonkish.enderitestorage.EnderiteReinforcedStorageMod;
import atonkish.enderitestorage.util.ReinforcingMaterialSettings;

public class ReinforcedChestsEntrypoint implements ReinforcedChestsModInitializer {
    @Override
    public void onInitializeReinforcedChests() {
        initializeReinforcedChests();
    }

    private static void initializeReinforcedChests() {
        for (ReinforcingMaterialSettings materialSettings : ReinforcingMaterialSettings.values()) {
            ReinforcingMaterial material = materialSettings.getMaterial();

            // Stats
            ReinforcedChestsRegistry.registerMaterialOpenStat(EnderiteReinforcedStorageMod.MOD_ID, material);

            // Blocks
            ReinforcedChestsRegistry.registerMaterialBlock(EnderiteReinforcedStorageMod.MOD_ID, material,
                    materialSettings.getBlockSettings());
            ReinforcedChestsRegistry.registerMaterialBlockEntityType(EnderiteReinforcedStorageMod.MOD_ID, material);

            // Items
            ReinforcedChestsRegistry.registerMaterialItem(EnderiteReinforcedStorageMod.MOD_ID, material,
                    materialSettings.getItemSettings());
        }
    }
}
