package atonkish.enderitestorage.entrypoint.reinfshulker;

import net.minecraft.util.DyeColor;

import atonkish.reinfcore.util.ReinforcingMaterial;
import atonkish.reinfshulker.api.ReinforcedShulkerBoxesModInitializer;
import atonkish.reinfshulker.api.ReinforcedShulkerBoxesRegistry;
import atonkish.enderitestorage.EnderiteReinforcedStorageMod;
import atonkish.enderitestorage.util.ReinforcingMaterialSettings;

public class ReinforcedShulkerBoxesEntrypoint implements ReinforcedShulkerBoxesModInitializer {
    @Override
    public void onInitializeReinforcedShulkerBoxes() {
        initializeReinforcedShulkerBoxes();
    }

    private static void initializeReinforcedShulkerBoxes() {
        for (ReinforcingMaterialSettings materialSettings : ReinforcingMaterialSettings.values()) {
            ReinforcingMaterial material = materialSettings.getMaterial();

            // Stats
            ReinforcedShulkerBoxesRegistry.registerMaterialCleanStat(EnderiteReinforcedStorageMod.MOD_ID, material);
            ReinforcedShulkerBoxesRegistry.registerMaterialOpenStat(EnderiteReinforcedStorageMod.MOD_ID, material);

            // Blocks
            ReinforcedShulkerBoxesRegistry.registerMaterialDyeColorBlock(EnderiteReinforcedStorageMod.MOD_ID, material,
                    (DyeColor) null, materialSettings.getShulkerBlockSettings());
            for (DyeColor color : DyeColor.values()) {
                ReinforcedShulkerBoxesRegistry.registerMaterialDyeColorBlock(EnderiteReinforcedStorageMod.MOD_ID,
                        material, color, materialSettings.getShulkerBlockSettings());
            }
            ReinforcedShulkerBoxesRegistry.registerMaterialBlockEntityType(EnderiteReinforcedStorageMod.MOD_ID,
                    material);

            // Items
            ReinforcedShulkerBoxesRegistry.registerMaterialDyeColorItem(EnderiteReinforcedStorageMod.MOD_ID, material,
                    (DyeColor) null, materialSettings.getShulkerItemSettings());
            for (DyeColor color : DyeColor.values()) {
                ReinforcedShulkerBoxesRegistry.registerMaterialDyeColorItem(EnderiteReinforcedStorageMod.MOD_ID,
                        material, color, materialSettings.getItemSettings());
            }
        }
    }
}
