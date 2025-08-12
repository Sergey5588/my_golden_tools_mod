package sergey5588.mgtm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.BlockBreakingInfo;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.command.TeamCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sergey5588.mgtm.custom.effects.StatueEffect;

import java.util.function.Function;

public class MyGoldenToolsMod implements ModInitializer {
	public static final String MOD_ID = "my-golden-tools-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryEntry<StatusEffect> STATUE =
			Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MyGoldenToolsMod.MOD_ID, "statue"), new StatueEffect()
					.addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.of(MOD_ID, "statue_a"), -1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
					.addAttributeModifier(EntityAttributes.JUMP_STRENGTH, Identifier.of(MOD_ID, "statue_a"), -1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
					.addAttributeModifier(EntityAttributes.KNOCKBACK_RESISTANCE, Identifier.of(MOD_ID, "statue_a"), 999999999, EntityAttributeModifier.Operation.ADD_VALUE)

			);

	@Override
	public void onInitialize() {

		ModItems.initialize();

		PlayerBlockBreakEvents.AFTER.register((world, playerEntity,blockPos,blockState,blockEntity)-> {
			if(playerEntity.getMainHandStack().isOf(Items.GOLDEN_PICKAXE) && (blockState.isOf(Blocks.GOLD_ORE) || blockState.isOf(Blocks.DEEPSLATE_GOLD_ORE)) && (playerEntity.getGameMode() != GameMode.CREATIVE)) {
				//playerEntity.dropItem(ModItems.MAGIC_SHARD.getDefaultStack(), true);
				world.spawnEntity(new ItemEntity(world, blockPos.getX()+0.5, blockPos.getY()+0.5, blockPos.getZ()+0.5, ModItems.MAGIC_SHARD.getDefaultStack()));
				world.spawnEntity(new ItemEntity(world, blockPos.getX()+0.5, blockPos.getY()+0.5, blockPos.getZ()+0.5, Items.GOLD_NUGGET.getDefaultStack().copyWithCount(Random.create().nextBetween(3,5))));

			}
		});
	}
}