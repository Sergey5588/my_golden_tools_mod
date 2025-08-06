package sergey5588.mgtm.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnchantmentScreenHandler.class)
public class ExampleMixin {
//	@ModifyReturnValue(at = @At(value = "RETURN", target = "$3"), method = "EnchantmentScreenHandler$3")
//	private void init(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, CallbackInfo info) {
//		// This code is injected into the start of MinecraftServer.loadWorld()V
//	}
}