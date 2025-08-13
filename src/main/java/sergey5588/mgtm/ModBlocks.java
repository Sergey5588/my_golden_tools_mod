package sergey5588.mgtm;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import sergey5588.mgtm.custom.blocks.AltarCore;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(MyGoldenToolsMod.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static final Block ALTAR_CORE = register("altar_core", AltarCore::new, AbstractBlock.Settings.create().strength(5.0f).requiresTool());

    public static void initialize() {

    }
}
