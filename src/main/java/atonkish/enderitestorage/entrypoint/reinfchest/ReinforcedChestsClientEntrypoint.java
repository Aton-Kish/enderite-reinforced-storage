package atonkish.enderitestorage.entrypoint.reinfchest;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import atonkish.reinfchest.api.ReinforcedChestsClientModInitializer;

@Environment(EnvType.CLIENT)
public class ReinforcedChestsClientEntrypoint implements ReinforcedChestsClientModInitializer {
    @Override
    public void onInitializeReinforcedChestsClient() {
    }
}
