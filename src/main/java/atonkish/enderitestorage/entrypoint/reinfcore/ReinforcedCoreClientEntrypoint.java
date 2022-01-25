package atonkish.enderitestorage.entrypoint.reinfcore;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import atonkish.enderitestorage.util.ReinforcingMaterialSettings;
import atonkish.reinfcore.api.ReinforcedCoreClientModInitializer;
import atonkish.reinfcore.api.ReinforcedCoreClientRegistry;
import atonkish.reinfcore.util.ReinforcingMaterial;

@Environment(EnvType.CLIENT)
public class ReinforcedCoreClientEntrypoint implements ReinforcedCoreClientModInitializer {
    @Override
    public void onInitializeReinforcedCoreClient() {
        initializeReinforcedCoreClient();
    }

    private static void initializeReinforcedCoreClient() {
        for (ReinforcingMaterialSettings materialSettings : ReinforcingMaterialSettings.values()) {
            ReinforcingMaterial material = materialSettings.getMaterial();

            // Reinforced Storage Screen
            ReinforcedCoreClientRegistry.registerMaterialSingleBlockScreen(material);
            ReinforcedCoreClientRegistry.registerMaterialDoubleBlockScreen(material);
            ReinforcedCoreClientRegistry.registerMaterialShulkerBoxScreen(material);
        }
    }
}
