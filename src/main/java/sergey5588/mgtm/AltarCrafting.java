package sergey5588.mgtm;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import sergey5588.mgtm.custom.blockEntities.AltarCoreBlockEntity;
import sergey5588.mgtm.utils.AltarCoreCraftC2SPayload;

import java.util.Arrays;

public class AltarCrafting {
    private static final Item[] GOLDEN_TOOLS = {
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
    private static final Item[][] INGREDIENTS = {
        {Items.LAPIS_LAZULI, Items.DIAMOND, Items.EMERALD}
    };
    private static final Item[] RESULTS = {
      Items.BLAZE_ROD
    };
    public static void process_crafting(DefaultedList<ItemStack> inventory) {

        if(Arrays.stream(GOLDEN_TOOLS).toList().contains(inventory.getFirst().getItem())) {
            inventory.getFirst().setDamage(0);
            return;
        }
        if(!inventory.getFirst().isOf(Items.AIR)) return;
        for(int i = 0; i < INGREDIENTS.length; ++i) {
            Item[] ing = INGREDIENTS[i];
            if(Arrays.stream(ing).toList().contains(inventory.get(1).getItem())){
                if(Arrays.stream(ing).toList().contains(inventory.get(2).getItem())) {
                    if(Arrays.stream(ing).toList().contains(inventory.get(3).getItem())) {
                        inventory.clear();
                        inventory.set(0, RESULTS[i].getDefaultStack());
                        return;

                    }
                }
            }
        }



    }
    public static void initialize() {
        ServerPlayNetworking.registerGlobalReceiver(AltarCoreCraftC2SPayload.ID, (payload, context) -> {

            BlockPos blockPos = new BlockPos((int)payload.pos().x,(int)payload.pos().y,(int)payload.pos().z);
            if(context.player().getWorld().getBlockEntity(blockPos) instanceof AltarCoreBlockEntity blockEntity) {
                process_crafting(blockEntity.getItems());
            }
        });
    }
}
