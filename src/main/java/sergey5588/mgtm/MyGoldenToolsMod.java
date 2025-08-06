package sergey5588.mgtm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class MyGoldenToolsMod implements ModInitializer {
	public static final String MOD_ID = "my-golden-tools-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ServerTickEvents.END_SERVER_TICK.register(( server) -> {
			for(ServerPlayerEntity player: server.getPlayerManager().getPlayerList()) {

				if(player.getInventory().contains(ModItems.MIDAS_TOUCH.getDefaultStack()) && !player.getWorld().getBlockState(player.getBlockPos().add(0,-1,0)).isAir()) {
					player.getWorld().setBlockState(player.getBlockPos().add(0,-1,0), Blocks.GOLD_BLOCK.getDefaultState());
				}
			}
		} );
	}
}