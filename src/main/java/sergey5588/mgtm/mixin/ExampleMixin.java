package sergey5588.mgtm.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sergey5588.mgtm.MyGoldenToolsMod;

@Mixin(Entity.class)
public abstract class ExampleMixin {
//    @Shadow public abstract boolean isLiving();
//
//    @Inject(at = @At("HEAD"), method = "isCollidable", cancellable = true)
//	private void isCollidable(@Nullable Entity entity, CallbackInfoReturnable<Boolean> cir) {
//        if((((Entity)(Object)this).isLiving() && ((LivingEntity)(Entity)(Object)this).hasStatusEffect(MyGoldenToolsMod.STATUE)) || (entity.isLiving() && ((LivingEntity)entity).hasStatusEffect(MyGoldenToolsMod.STATUE)) ) {
//            ((Entity)(Object)this).getWorld().getPlayers().getFirst().sendMessage(Text.of("FUCK"), false);
//            cir.setReturnValue(false);
//        }
//    }
}