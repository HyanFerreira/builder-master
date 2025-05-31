package net.hfstack.buildermaster.item;

import net.hfstack.buildermaster.BuilderMaster;
import net.hfstack.buildermaster.item.custom.ModArmorItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BUILDER_INITIATE_HELMET = registerItem("builder_initiate_helmet",
            new ModArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item BUILDER_INITIATE_CHESTPLATE = registerItem("builder_initiate_chestplate",
            new ModArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item BUILDER_INITIATE_LEGGINGS = registerItem("builder_initiate_leggings",
            new ModArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item BUILDER_INITIATE_BOOTS = registerItem("builder_initiate_boots",
            new ModArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item BUILDER_ADVANCED_HELMET = registerItem("builder_advanced_helmet",
            new ModArmorItem(ModArmorMaterials.BUILDER_ADV_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item BUILDER_ADVANCED_CHESTPLATE = registerItem("builder_advanced_chestplate",
            new ModArmorItem(ModArmorMaterials.BUILDER_ADV_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item BUILDER_ADVANCED_LEGGINGS = registerItem("builder_advanced_leggings",
            new ModArmorItem(ModArmorMaterials.BUILDER_ADV_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item BUILDER_ADVANCED_BOOTS = registerItem("builder_advanced_boots",
            new ModArmorItem(ModArmorMaterials.BUILDER_ADV_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BuilderMaster.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BuilderMaster.LOGGER.info("Registering Mod Items for " + BuilderMaster.MOD_ID);
    }
}
