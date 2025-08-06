package sergey5588.mgtm;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.transfer.v1.item.PlayerInventoryStorage;
import net.minecraft.block.entity.EnchantingTableBlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyGoldenToolsMod.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    public static final Item MIDAS_TOUCH = register("midas_touch", Item::new, new Item.Settings().maxCount(1).rarity(Rarity.EPIC));

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MyGoldenToolsMod.MOD_ID, "mgtm"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.MIDAS_TOUCH))
            .displayName(Text.translatable("itemGroup.mgtm"))
            .build();
    public static void initialize() {
        Item[] golden_tools = {
                Items.GOLDEN_PICKAXE,
                Items.GOLDEN_AXE,
                Items.GOLDEN_BOOTS,
                Items.GOLDEN_CHESTPLATE,
                Items.GOLDEN_HELMET,
                Items.GOLDEN_HOE,
                Items.GOLDEN_HORSE_ARMOR,
                Items.GOLDEN_LEGGINGS,
                Items.GOLDEN_SHOVEL,
                Items.GOLDEN_SWORD
        };






        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY)
                .register((itemGroup) -> itemGroup.add(ModItems.MIDAS_TOUCH));
    }
}
