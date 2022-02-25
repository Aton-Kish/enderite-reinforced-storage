package atonkish.enderitestorage.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

import net.enderitemc.enderitemod.EnderiteMod;

import atonkish.reinfcore.api.ReinforcedCoreRegistry;
import atonkish.reinfcore.item.ModItemGroup;
import atonkish.reinfcore.util.ReinforcingMaterial;

public enum ReinforcingMaterialSettings {
    ENDERITE(ReinforcedCoreRegistry.registerReinforcingMaterial("enderite", 108, EnderiteMod.ENDERITE_INGOT),
            FabricBlockSettings.of(Material.METAL, MapColor.BLACK).strength(2.5F, 1200.0F)
                    .sounds(BlockSoundGroup.NETHERITE),
            new Item.Settings().group(ModItemGroup.REINFORCED_STORAGE));

    private final ReinforcingMaterial material;
    private final Block.Settings blockSettings;
    private final Item.Settings itemSettings;

    private ReinforcingMaterialSettings(ReinforcingMaterial material, Block.Settings blockSettings,
            Item.Settings itemSettings) {
        this.material = material;
        this.blockSettings = blockSettings;
        this.itemSettings = itemSettings;
    }

    public ReinforcingMaterial getMaterial() {
        return this.material;
    }

    public Block.Settings getBlockSettings() {
        return this.blockSettings;
    }

    public Item.Settings getItemSettings() {
        return this.itemSettings;
    }

    public Block.Settings getShulkerBlockSettings() {
        AbstractBlock.ContextPredicate contextPredicate = (state, world, pos) -> {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (!(blockEntity instanceof ShulkerBoxBlockEntity)) {
                return true;
            } else {
                ShulkerBoxBlockEntity shulkerBoxBlockEntity = (ShulkerBoxBlockEntity) blockEntity;
                return shulkerBoxBlockEntity.suffocates();
            }
        };

        return this.blockSettings.dynamicBounds().nonOpaque().suffocates(contextPredicate)
                .blockVision(contextPredicate);
    }

    public Item.Settings getShulkerItemSettings() {
        return this.itemSettings.maxCount(1);
    }
}
