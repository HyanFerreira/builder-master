package net.hfstack.buildermaster.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hfstack.buildermaster.BuilderMaster;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup BUILDER_MASTER_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BuilderMaster.MOD_ID, "builder_master_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BUILDER_INITIATE_HELMET))
                    .displayName(Text.translatable("itemGroup.buildermaster.builder_master_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BUILDER_INITIATE_HELMET);
                        entries.add(ModItems.BUILDER_INITIATE_CHESTPLATE);
                        entries.add(ModItems.BUILDER_INITIATE_LEGGINGS);
                        entries.add(ModItems.BUILDER_INITIATE_BOOTS);

                        entries.add(ModItems.BUILDER_ADVANCED_HELMET);
                        entries.add(ModItems.BUILDER_ADVANCED_CHESTPLATE);
                        entries.add(ModItems.BUILDER_ADVANCED_LEGGINGS);
                        entries.add(ModItems.BUILDER_ADVANCED_BOOTS);

                        entries.add(ModItems.BUILDER_MASTER_HELMET);
                        entries.add(ModItems.BUILDER_MASTER_CHESTPLATE);
                        entries.add(ModItems.BUILDER_MASTER_LEGGINGS);
                        entries.add(ModItems.BUILDER_MASTER_BOOTS);

                    }).build());

    public static void registerModItemGroups() {
        BuilderMaster.LOGGER.info("Registering Mod Item Groups for " + BuilderMaster.MOD_ID);
    }
}
