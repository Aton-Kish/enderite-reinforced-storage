package atonkish.enderitestorage.mixin;

import java.util.ArrayList;
import java.util.Map;

import com.google.gson.JsonElement;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import atonkish.enderitestorage.EnderiteReinforcedStorageMod;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {
    @Inject(method = "apply", at = @At("HEAD"))
    private void removeMissingIdentifier(Map<Identifier, JsonElement> map, ResourceManager resourceManager,
            Profiler profiler, CallbackInfo info) {
        ArrayList<Identifier> missingIdentifiers = new ArrayList<>();
        for (Identifier id : map.keySet()) {
            if (!id.getNamespace().equals(EnderiteReinforcedStorageMod.MOD_ID)) {
                continue;
            }

            String path = id.getPath();
            if ((!EnderiteReinforcedStorageMod.IS_REINFCHEST_LOADED && path.contains("chest")) ||
                    (!EnderiteReinforcedStorageMod.IS_REINFSHULKER_LOADED && path.contains("shulker_box")) ||
                    (!EnderiteReinforcedStorageMod.IS_REINFBARREL_LOADED && path.contains("barrel"))) {
                missingIdentifiers.add(id);
            }
        }

        missingIdentifiers.forEach(map::remove);
    }
}