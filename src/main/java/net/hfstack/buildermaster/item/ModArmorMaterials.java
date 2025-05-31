package net.hfstack.buildermaster.item;

import net.hfstack.buildermaster.BuilderMaster;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> BUILDER_INIT_ARMOR_MATERIAL = registerArmorMaterial("builder_initiate",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 2);
                        map.put(ArmorItem.Type.CHESTPLATE, 2);
                        map.put(ArmorItem.Type.HELMET, 1);
                    }),
                    15,
                    SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    () -> Ingredient.ofItems(Items.IRON_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BuilderMaster.MOD_ID, "builder_initiate"))),
                    0.0f,
                    0.0f
            )
    );

    public static final RegistryEntry<ArmorMaterial> BUILDER_ADV_ARMOR_MATERIAL = registerArmorMaterial("builder_advanced",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 2);
                        map.put(ArmorItem.Type.CHESTPLATE, 2);
                        map.put(ArmorItem.Type.HELMET, 2);
                    }),
                    15,
                    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(Items.DIAMOND),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BuilderMaster.MOD_ID, "builder_advanced"))),
                    0.0f,
                    0.0f
            )
    );

    public static final RegistryEntry<ArmorMaterial> BUILDER_MASTER_ARMOR_MATERIAL = registerArmorMaterial("builder_master",
            () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 3);
                        map.put(ArmorItem.Type.CHESTPLATE, 3);
                        map.put(ArmorItem.Type.HELMET, 3);
                    }),
                    15,
                    SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.ofItems(Items.NETHERITE_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BuilderMaster.MOD_ID, "builder_master"))),
                    0.0f,
                    0.0f
            )
    );

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(BuilderMaster.MOD_ID, name), material.get());
    }
}
