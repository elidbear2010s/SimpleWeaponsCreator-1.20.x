package net.elidbear2010.simpleweaponscreator.items;

import net.elidbear2010.simpleweaponscreator.SimpleWeaponsCreator;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SimpleWeaponsCreator.MOD_ID);

    public static final DeferredItem<Item> CRYSTAL = ITEMS.register("crystal",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROUGHCRYSTAL = ITEMS.register("roughcrystal",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
