package com.nova.hitbox.mixin;

import com.nova.hitbox.NovaHitboxExpander;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityDimensionsMixin {
    @Inject(method = "getDimensions", at = @At("RETURN"), cancellable = true)
    private void nova$expandDimensions(EntityPose pose, CallbackInfoReturnable<EntityDimensions> cir) {
        if (NovaHitboxExpander.ENABLED) {
            cir.setReturnValue(cir.getReturnValue().scaled(
                    NovaHitboxExpander.WIDTH_SCALE,
                    NovaHitboxExpander.HEIGHT_SCALE
            ));
        }
    }
}
