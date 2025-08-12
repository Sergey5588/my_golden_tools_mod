package sergey5588.mgtm.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sergey5588.mgtm.MyGoldenToolsMod;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {


    @Inject(at = @At("HEAD"), method = "isPushable", cancellable = true)
	private void isPushable(CallbackInfoReturnable<Boolean> cir) {
        if((((LivingEntity)(Object)this).hasStatusEffect(MyGoldenToolsMod.STATUE))) {
            cir.setReturnValue(false);
        }
    }
}