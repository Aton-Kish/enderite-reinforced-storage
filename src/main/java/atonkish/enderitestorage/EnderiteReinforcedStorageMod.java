package atonkish.enderitestorage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import atonkish.reinfbarrel.ReinforcedBarrelsMod;
import atonkish.reinfchest.ReinforcedChestsMod;
import atonkish.reinfshulker.ReinforcedShulkerBoxesMod;

public class EnderiteReinforcedStorageMod implements ModInitializer {
	public static final String MOD_ID = "enderitestorage";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean IS_REINFCHEST_LOADED = false;
	public static boolean IS_REINFSHULKER_LOADED = false;
	public static boolean IS_REINFBARREL_LOADED = false;

	@Override
	public void onInitialize() {
		IS_REINFCHEST_LOADED = FabricLoader.getInstance().isModLoaded(ReinforcedChestsMod.MOD_ID);
		IS_REINFSHULKER_LOADED = FabricLoader.getInstance().isModLoaded(ReinforcedShulkerBoxesMod.MOD_ID);
		IS_REINFBARREL_LOADED = FabricLoader.getInstance().isModLoaded(ReinforcedBarrelsMod.MOD_ID);

		if (!(IS_REINFCHEST_LOADED || IS_REINFSHULKER_LOADED || IS_REINFBARREL_LOADED)) {
			LOGGER.warn("Any Reinforced Storage mods `{}`, `{}`, `{}` have not been loaded "
					+ "- The Enderite Reinforced Storage mod `{}` will do nothing.",
					ReinforcedChestsMod.MOD_ID, ReinforcedShulkerBoxesMod.MOD_ID, ReinforcedBarrelsMod.MOD_ID, MOD_ID);
		}
	}
}
