package sergey5588.mgtm.custom.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sergey5588.mgtm.ModBlockEntityTypes;
import sergey5588.mgtm.MyGoldenToolsMod;
import sergey5588.mgtm.custom.blockEntities.AltarCoreBlockEntity;

public class AltarCore extends BlockWithEntity {
    public AltarCore(Block.Settings settings) {
        super(settings);
    }
    public static final BlockPos[] Positions = {
            new BlockPos(0,-1,0),
            new BlockPos(1,-1,0),
            new BlockPos(1,-1,1),
            new BlockPos(0,-1,1),
            new BlockPos(-1,-1,1),
            new BlockPos(1,-1,-1),
            new BlockPos(0,-1,-1),
            new BlockPos(-1,-1,-1),
            new BlockPos(-1,-1,0),
    };
    public static final Block[] StructureBlocks = {
            Blocks.LAPIS_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_BLOCK,
            Blocks.GOLD_BLOCK,


    };
    public boolean isValidStructure(World world,BlockPos pos) {
        for(int i=0; i < Positions.length; ++i) {
            if(!world.getBlockState(Positions[i].add(pos.getX(), pos.getY(), pos.getZ())).isOf(StructureBlocks[i])) {
                return false;
            }
        }

        return true;
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

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            if(isValidStructure(world, pos))
                player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            else
                player.sendMessage(Text.translatable("gui.my-golden-tools-mod.invalid_multiblock"), true);
        }
        return ActionResult.SUCCESS;
    }







}
