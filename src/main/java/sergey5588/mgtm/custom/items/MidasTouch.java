package sergey5588.mgtm.custom.items;



import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import sergey5588.mgtm.MyGoldenToolsMod;

public class MidasTouch extends Item {
    public static final int COOLDOWN = 100;
    public static final int DURATION = 50;
    public MidasTouch(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(user.getItemCooldownManager().isCoolingDown(stack))
            return ActionResult.FAIL;

        stack.setDamage(stack.getDamage()+1);
        user.getStackInHand(hand).setDamage(user.getStackInHand(hand).getDamage()+1);
        entity.addStatusEffect(new StatusEffectInstance(MyGoldenToolsMod.STATUE, DURATION, 255, false, false, true ), entity);
        if(stack.shouldBreak()) {
            user.playSound(SoundEvents.BLOCK_ANVIL_BREAK, 0.5f,1.0f);
            user.setStackInHand(hand, ItemStack.EMPTY);
        }
        user.getItemCooldownManager().set(stack, COOLDOWN);
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext ctx) {
        if(ctx.getWorld().getBlockState(ctx.getBlockPos()).isOf(Blocks.GOLD_BLOCK) || ctx.getWorld().getBlockState(ctx.getBlockPos()).isOf(Blocks.BEDROCK)) {
            return  ActionResult.FAIL;
        }
        if(ctx.getPlayer() !=null) {
            if(ctx.getPlayer().getItemCooldownManager().isCoolingDown(ctx.getStack()))
                return ActionResult.FAIL;
            ctx.getWorld().setBlockState(ctx.getBlockPos(), Blocks.GOLD_BLOCK.getDefaultState());

            ctx.getPlayer().playSound(SoundEvents.BLOCK_IRON_PLACE, 0.5f, 1.0f);
            ctx.getStack().setDamage(ctx.getStack().getDamage()+1);
            if(ctx.getStack().shouldBreak()) {

                ctx.getPlayer().playSound(SoundEvents.BLOCK_ANVIL_BREAK, 0.5f,1.0f);
                ctx.getPlayer().setStackInHand(ctx.getHand(), ItemStack.EMPTY);
            }
            ctx.getPlayer().getItemCooldownManager().set(ctx.getStack(), COOLDOWN);
        }
        return ActionResult.SUCCESS;
    }
}
