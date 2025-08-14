package sergey5588.mgtm.custom.blockEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sergey5588.mgtm.ModBlockEntityTypes;

public class AltarCoreBlockEntity extends BlockEntity {
    public AltarCoreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.ALTAR_CORE, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, AltarCoreBlockEntity blockEntity) {

    }
}
