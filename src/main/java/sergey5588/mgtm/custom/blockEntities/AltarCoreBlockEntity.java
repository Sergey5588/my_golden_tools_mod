package sergey5588.mgtm.custom.blockEntities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sergey5588.mgtm.ModBlockEntityTypes;
import sergey5588.mgtm.custom.screens.AltarCoreScreenHandler;
import sergey5588.mgtm.utils.ImplementedInventory;

public class AltarCoreBlockEntity extends BlockEntity implements ImplementedInventory,ExtendedScreenHandlerFactory<BlockPos> {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public AltarCoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.ALTAR_CORE, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, AltarCoreBlockEntity blockEntity) {

    }

    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());

    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AltarCoreScreenHandler(syncId,playerInventory, this.pos);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }



    @Override
    public void writeData(WriteView view) {
        super.writeData(view);

        Inventories.writeData(view, inventory);

    }

    @Override
    public void readData(ReadView view) {
        super.readData(view);

        Inventories.readData(view, inventory);
    }

    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
