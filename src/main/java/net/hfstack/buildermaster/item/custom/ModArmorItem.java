package net.hfstack.buildermaster.item.custom;

import com.google.common.collect.ImmutableMap;
import net.hfstack.buildermaster.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.HASTE, 400, 0, false, false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 0, false, false)))
                    .put(ModArmorMaterials.BUILDER_ADV_ARMOR_MATERIAL,
                            List.of(
                                    new StatusEffectInstance(StatusEffects.HASTE, 400, 2, false, false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1, false, false),
                                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false)))
                    .put(ModArmorMaterials.BUILDER_MASTER_ARMOR_MATERIAL,
                            List.of(
                                    new StatusEffectInstance(StatusEffects.HASTE, 400, 4, false, false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 2, false, false),
                                    new StatusEffectInstance(StatusEffects.SPEED, 400, 1, false, false),
                                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0, false, false)))
                    .build();

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        boolean isWearingMasterSet = hasCorrectArmorOn(ModArmorMaterials.BUILDER_MASTER_ARMOR_MATERIAL, player);

        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
        }

        // Habilita o voo se estiver com a armadura master
        if (isWearingMasterSet) {
            if (!player.getAbilities().allowFlying) {
                player.getAbilities().allowFlying = true;
                player.sendAbilitiesUpdate();
            }
        } else {
            // Remove a habilidade de voar se o jogador não estiver em modo criativo/espectador
            if (!player.isCreative() && !player.isSpectator() && player.getAbilities().allowFlying) {
                player.getAbilities().flying = false;
                player.getAbilities().allowFlying = false;
                player.sendAbilitiesUpdate();
            }
        }
    }


    private void addStatusEffectForMaterial(PlayerEntity player, RegistryEntry<ArmorMaterial> mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if (!hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasCorrectArmorOn(RegistryEntry<ArmorMaterial> material, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem armorItem) || !armorItem.getMaterial().equals(material)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        return !player.getInventory().getArmorStack(3).isEmpty()
                && !player.getInventory().getArmorStack(2).isEmpty()
                && !player.getInventory().getArmorStack(1).isEmpty()
                && !player.getInventory().getArmorStack(0).isEmpty();
    }

}