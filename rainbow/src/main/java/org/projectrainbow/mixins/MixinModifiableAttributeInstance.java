package org.projectrainbow.mixins;

import PluginReference.MC_Attribute;
import PluginReference.MC_AttributeModifier;
import PluginReference.MC_AttributeType;
import com.google.common.base.Objects;
import net.minecraft.src.AttributeModifier;
import net.minecraft.src.IAttributeInstance;
import net.minecraft.src.ModifiableAttributeInstance;
import org.projectrainbow.PluginHelper;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Collection;

@Mixin(ModifiableAttributeInstance.class)
@Implements(@Interface(iface = MC_Attribute.class, prefix = "api$"))
public abstract class MixinModifiableAttributeInstance implements IAttributeInstance {
    /**
     * Get the type of this attribute.
     *
     * @return the type
     */
    public MC_AttributeType api$getType() {
        return Objects.firstNonNull(PluginHelper.attributeMap.inverse().get(getAttribute()), MC_AttributeType.HORSE_JUMP_STRENGTH);
    }

    /**
     * Get the base value of this attribute. The base value of an attribute is
     * different for different entities.
     *
     * @return the base value
     */
    public double api$getBaseValue() {
        return getBaseValue();
    }

    /**
     * Set the base value of this attribute.
     *
     * @param baseValue the new base value
     */
    public void api$setBaseValue(double baseValue) {
        setBaseValue(baseValue);
    }

    /**
     * Get the value of this attribute after applying the modifiers.
     *
     * @return the effective value
     */
    public double api$getEffectiveValue() {
        return getAttributeValue();
    }

    /**
     * Get all modifiers of this attribute.
     *
     * @return an immutable collection of the modifiers
     */
    public Collection<? extends MC_AttributeModifier> api$getModifiers() {
        return (Collection<? extends MC_AttributeModifier>) (Collection) c();
    }

    /**
     * Remove a modifier from this attribute.
     *
     * @param modifier the modifier to remove
     */
    public void api$removeModifier(MC_AttributeModifier modifier) {
        removeModifier((AttributeModifier) modifier);
    }

    /**
     * Add a modifier to this attribute.
     *
     * @param modifier the modifier to add
     */
    public void api$addModifier(MC_AttributeModifier modifier) {
        applyModifier((AttributeModifier) modifier);
    }
}