package net.elidbear2010.simpleweaponscreator.block;

import net.elidbear2010.simpleweaponscreator.SimpleWeaponsCreator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    static public final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SimpleWeaponsCreator.MOD_ID);



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
