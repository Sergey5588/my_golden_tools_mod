package sergey5588.mgtm.mixin.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.CollisionEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import net.minecraft.world.entity.ClientEntityManager;
import net.minecraft.world.level.storage.LevelSummary;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sergey5588.mgtm.MyGoldenToolsMod;

@Mixin(LevelSummary.class)
public abstract class ExampleClientMixin {


//	@Inject(at = @At("HEAD"), method = "isExperimental", cancellable = true)
//	private void isCollidable(CallbackInfoReturnable<Boolean> cir) {
//		cir.setReturnValue(false);
//	}
}