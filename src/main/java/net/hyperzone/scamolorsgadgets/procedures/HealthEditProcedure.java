package net.hyperzone.scamolorsgadgets.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.GameType;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsMod;

import java.util.Map;
import java.util.HashMap;

public class HealthEditProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("endconquered", event.isEndConquered());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency entity for procedure HealthEdit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.extinguish();
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.SURVIVAL);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/attribute @s minecraft:generic.max_health base set 200");
			}
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 1200, (int) 6, (true), (false)));
		entity.fallDistance = (float) (0);
	}
}
