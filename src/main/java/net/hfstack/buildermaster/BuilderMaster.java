package net.hfstack.buildermaster;

import net.fabricmc.api.ModInitializer;

import net.hfstack.buildermaster.item.ModItemGroups;
import net.hfstack.buildermaster.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuilderMaster implements ModInitializer {
    public static final String MOD_ID = "buildermaster";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerModItemGroups();
        ModItems.registerModItems();
    }
}