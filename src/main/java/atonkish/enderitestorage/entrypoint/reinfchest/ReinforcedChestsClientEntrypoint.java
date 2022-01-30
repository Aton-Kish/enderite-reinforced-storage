package atonkish.enderitestorage.entrypoint.reinfchest;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import atonkish.reinfcore.util.ReinforcingMaterial;
import atonkish.reinfchest.api.ReinforcedChestsClientModInitializer;
import atonkish.reinfchest.api.ReinforcedChestsClientRegistry;
import atonkish.reinfchest.block.ModBlocks;
import atonkish.reinfchest.block.ReinforcedChestBlock;
import atonkish.reinfchest.block.entity.ModBlockEntityType;
import atonkish.reinfchest.block.entity.ReinforcedChestBlockEntity;
import atonkish.reinfchest.client.render.block.entity.ReinforcedChestBlockEntityRenderer;
import atonkish.enderitestorage.EnderiteReinforcedStorageMod;
import atonkish.enderitestorage.util.ReinforcingMaterialSettings;

@Environment(EnvType.CLIENT)
public class ReinforcedChestsClientEntrypoint implements ReinforcedChestsClientModInitializer {
    @Override
    public void onInitializeReinforcedChestsClient() {
        initializeReinforcedChestsClient();
    }

    private static void initializeReinforcedChestsClient() {
        for (ReinforcingMaterialSettings materialSettings : ReinforcingMaterialSettings.values()) {
            ReinforcingMaterial material = materialSettings.getMaterial();

            // Textured Render Layers
            ReinforcedChestsClientRegistry.registerMaterialAtlasTexture(EnderiteReinforcedStorageMod.MOD_ID, material);
            ReinforcedChestsClientRegistry.registerMaterialRenderLayer(EnderiteReinforcedStorageMod.MOD_ID, material);
            ReinforcedChestsClientRegistry.registerMaterialSingleSprite(EnderiteReinforcedStorageMod.MOD_ID, material);
            ReinforcedChestsClientRegistry.registerMaterialLeftSprite(EnderiteReinforcedStorageMod.MOD_ID, material);
            ReinforcedChestsClientRegistry.registerMaterialRightSprite(EnderiteReinforcedStorageMod.MOD_ID, material);

            // Block Entity Renderer
            BlockEntityRendererRegistry
                    .register(ModBlockEntityType.REINFORCED_CHEST_MAP.get(material),
                            ReinforcedChestBlockEntityRenderer::new);

            // Item Renderer
            Block block = ModBlocks.REINFORCED_CHEST_MAP.get(material);
            BuiltinItemRendererRegistry.INSTANCE.register(block,
                    (ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices,
                            VertexConsumerProvider vertexConsumers, int light, int overlay) -> {
                        BlockEntity blockEntity = new ReinforcedChestBlockEntity(material, BlockPos.ORIGIN,
                                block.getDefaultState().with(ReinforcedChestBlock.FACING, Direction.SOUTH));
                        MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(blockEntity,
                                matrices,
                                vertexConsumers, light, overlay);
                    });
        }
    }
}
