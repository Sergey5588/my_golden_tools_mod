package sergey5588.mgtm.custom.items;



import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MidasTouch extends Item {

    public MidasTouch(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {


        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 255, false, false, false ), entity);
        if(stack.isDamageable()) {

            
            if(stack.shouldBreak()) {
                stack.decrement(0);
                user.playSound(SoundEvents.BLOCK_IRON_PLACE, 0.5f,1.0f);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext ctx) {
        if(ctx.getWorld().getBlockState(ctx.getBlockPos()).isOf(Blocks.GOLD_BLOCK)) {
            return  ActionResult.FAIL;
        }
        ctx.getWorld().setBlockState(ctx.getBlockPos(), Blocks.GOLD_BLOCK.getDefaultState());
        if(ctx.getPlayer() !=null) {

            ctx.getPlayer().playSound(SoundEvents.BLOCK_IRON_PLACE, 0.5f, 1.0f);
        }
        return ActionResult.SUCCESS;
    }
}
