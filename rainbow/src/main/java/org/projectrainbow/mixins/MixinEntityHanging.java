package org.projectrainbow.mixins;

import PluginReference.MC_Entity;
import PluginReference.MC_EventInfo;
import PluginReference.MC_HangingEntityType;
import PluginReference.MC_Player;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.DamageSource;
import org.projectrainbow.Hooks;
import org.projectrainbow.PluginHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityHanging.class)
public abstract class MixinEntityHanging extends MixinEntity {

    @Inject(method = "attackEntityFrom", at = @At("HEAD"), cancellable = true)
    private void onAttacked2(DamageSource damageSource, float damage, CallbackInfoReturnable<Boolean> callbackInfo) {
        m_rainbowAdjustedDamage = damage;
        damageModified = false;
        attacker = (MC_Entity) damageSource.getTrueSource();

        MC_EventInfo ei = new MC_EventInfo();

        Hooks.onAttemptEntityDamage(this, PluginHelper.wrap(damageSource), damage, ei);

        if (ei.isCancelled) {
            callbackInfo.cancel();
            callbackInfo.setReturnValue(false);
        }

        ei = new MC_EventInfo();

        MC_HangingEntityType type = MC_HangingEntityType.UNSPECIFIED;

        if (((Object) this) instanceof EntityLeashKnot) {
            type = MC_HangingEntityType.LEASH_KNOT;
        } else if (((Object) this) instanceof EntityItemFrame) {
            type = MC_HangingEntityType.ITEM_FRAME;
        } else if (((Object) this) instanceof EntityPainting) {
            type = MC_HangingEntityType.PAINTING;
        }

        Hooks.onAttemptDamageHangingEntity(attacker instanceof MC_Player ? (MC_Player) attacker : null, getLocation(), type, ei);

        if (ei.isCancelled) {
            callbackInfo.cancel();
            callbackInfo.setReturnValue(false);
        }
    }
}
