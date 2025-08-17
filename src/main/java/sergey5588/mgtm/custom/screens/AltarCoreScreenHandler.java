package sergey5588.mgtm.custom.screens;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.BeaconScreenHandler;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import sergey5588.mgtm.ModScreenHandlers;

public class AltarCoreScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public final BlockEntity bEntity;
    public AltarCoreScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId,playerInventory, playerInventory.player.getWorld().getBlockEntity(pos));
    }



    public AltarCoreScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ModScreenHandlers.ALTAR_CORE_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity );
        this.bEntity = blockEntity;
        this.addSlot(new Slot(inventory, 0, 80, 35 ) {
            public int getMaxItemCount() {
                return 64;
            }
        });
        this.addSlot(new Slot(inventory, 1, 80, 10 ) {
            public int getMaxItemCount() {
                return 64;
            }
        });
        this.addSlot(new Slot(inventory, 2, 44, 35 ) {
            public int getMaxItemCount() {
                return 64;
            }
        });
        this.addSlot(new Slot(inventory, 3, 116, 35 ) {
            public int getMaxItemCount() {
                return 64;
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
