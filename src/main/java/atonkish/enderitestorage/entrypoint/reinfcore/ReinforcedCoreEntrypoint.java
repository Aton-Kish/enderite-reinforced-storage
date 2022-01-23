package atonkish.enderitestorage.entrypoint.reinfcore;

import atonkish.reinfcore.api.ReinforcedCoreModInitializer;
import atonkish.reinfcore.api.ReinforcedCoreRegistry;
import atonkish.reinfcore.util.ReinforcingMaterial;
import atonkish.enderitestorage.util.ReinforcingMaterialSettings;

public class ReinforcedCoreEntrypoint implements ReinforcedCoreModInitializer {
    @Override
    public void onInitializeReinforcedCore() {
        initializeReinforcedCore();
    }

    private static void initializeReinforcedCore() {
        for (ReinforcingMaterialSettings materialSettings : ReinforcingMaterialSettings.values()) {
            ReinforcingMaterial material = materialSettings.getMaterial();

            // Reinforced Storage Screen Model
            ReinforcedCoreRegistry.registerMaterialSingleBlockScreenModel(material);
            ReinforcedCoreRegistry.registerMaterialDoubleBlockScreenModel(material);

            // Reinforced Storage Screen Handler
            ReinforcedCoreRegistry.registerMaterialSingleBlockScreenHandler(material);
            ReinforcedCoreRegistry.registerMaterialDoubleBlockScreenHandler(material);
        }
    }
}
