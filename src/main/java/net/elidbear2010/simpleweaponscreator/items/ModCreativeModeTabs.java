package net.elidbear2010.simpleweaponscreator.items;

import com.ibm.icu.text.CaseMap;
import net.elidbear2010.simpleweaponscreator.SimpleWeaponsCreator;
import net.elidbear2010.simpleweaponscreator.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleWeaponsCreator.MOD_ID);

    public static final Supplier<CreativeModeTab> SIMPLEWEAPONSCREATOR_ITEMS_TAB = CREATIVE_MODE_TAB.register("simpleweaponscreator_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CRYSTAL.get()))
            .title(Component.translatable("creativetab.simpleweaponscreator.simpleweaponscreator_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CRYSTAL);
                        output.accept(ModItems.ROUGHCRYSTAL);

                    }).build());

    public static final Supplier<CreativeModeTab> SIMPLEWEAPONSCREATOR_BLOCKS_TAB = CREATIVE_MODE_TAB.register("simpleweaponscreator_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRYSTAL_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SimpleWeaponsCreator.MOD_ID, "simpleweaponscreator_items_tab"))
                    .title(Component.translatable("creativetab.simpleweaponscreator.simpleweaponscreator_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CRYSTAL_BLOCK);
                        output.accept(ModBlocks.ROUGHCRYSTAL_BLOCK);
                        output.accept(ModBlocks.CRYSTAL_ORE);


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}