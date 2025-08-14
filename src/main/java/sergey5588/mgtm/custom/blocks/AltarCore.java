package sergey5588.mgtm.custom.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sergey5588.mgtm.ModBlockEntityTypes;
import sergey5588.mgtm.ModBlocks;
import sergey5588.mgtm.custom.blockEntities.AltarCoreBlockEntity;

public class AltarCore extends BlockWithEntity {
    public AltarCore(Block.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends AltarCore> getCodec() {
        return createCodec(AltarCore::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarCoreBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntityTypes.ALTAR_CORE, AltarCoreBlockEntity::tick);
    }


}
