package sergey5588.mgtm;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import sergey5588.mgtm.custom.blockEntities.AltarCoreBlockEntity;
import sergey5588.mgtm.utils.AltarCoreCraftC2SPayload;

public class AltarCrafting {
    private static final Item[] GOLDEN_TOOLS = {

    };

    private void process_crafting() {

    }
    public static void initialize() {
        ServerPlayNetworking.registerGlobalReceiver(AltarCoreCraftC2SPayload.ID, (payload, context) -> {

            BlockPos blockPos = new BlockPos((int)payload.pos().x,(int)payload.pos().y,(int)payload.pos().z);
            if(context.player().getWorld().getBlockEntity(blockPos) instanceof AltarCoreBlockEntity blockEntity) {
                blockEntity.getItems().set(0, ItemStack.EMPTY);
            }
        });
    }
}
