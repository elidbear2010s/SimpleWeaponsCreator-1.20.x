package net.elidbear2010.simpleweaponscreator.block;

import net.elidbear2010.simpleweaponscreator.SimpleWeaponsCreator;
import net.elidbear2010.simpleweaponscreator.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    static public final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SimpleWeaponsCreator.MOD_ID);

    public static final DeferredBlock<Block> ROUGHCRYSTAL_BLOCK = registerBlock("roughcrystal_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CRYSTAL_BLOCK = registerBlock("crystal_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CRYSTAL_ORE = registerBlock("crystal_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
