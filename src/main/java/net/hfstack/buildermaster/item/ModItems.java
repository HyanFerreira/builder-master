package net.hfstack.buildermaster.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hfstack.buildermaster.BuilderMaster;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

//    public static final Item SCROLL_OF_RALLYING = registerItem("scroll_of_rallying",
//            new Item(new Item.Settings().maxCount(1)));

    public static final Item BUILDER_INITIATE_HELMET = registerItem("builder_initiate_helmet",
            new ArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item BUILDER_INITIATE_CHESTPLATE = registerItem("builder_initiate_chestplate",
            new ArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item BUILDER_INITIATE_LEGGINGS = registerItem("builder_initiate_leggings",
            new ArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item BUILDER_INITIATE_BOOTS = registerItem("builder_initiate_boots",
            new ArmorItem(ModArmorMaterials.BUILDER_INIT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BuilderMaster.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BuilderMaster.LOGGER.info("Registering Mod Items for " + BuilderMaster.MOD_ID);

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
//            entries.add(SCROLL_OF_RALLYING);
//        });
    }
}
