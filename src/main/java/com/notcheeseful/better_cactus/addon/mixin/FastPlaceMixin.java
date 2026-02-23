package com.notcheeseful.better_cactus.addon.mixin;

import com.notcheeseful.better_cactus.addon.feature.modules.FastPlace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.item.BlockItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(GameRenderer.class)
public class FastPlaceMixin {

    @Inject(method = "pick", at = @At("HEAD"))
    private void onPickStart(float f, CallbackInfo ci) {
        if (FastPlace.INSTANCE != null && FastPlace.INSTANCE.active()) {
            Minecraft minecraft = Minecraft.getInstance();

            // Only apply fast place if holding a block item
            if (minecraft.player != null && minecraft.player.getMainHandItem().getItem() instanceof BlockItem) {
                MinecraftAccessor accessor = (MinecraftAccessor) (Object) minecraft;
                accessor.setRightClickDelay(0);
            }
        }
    }
}