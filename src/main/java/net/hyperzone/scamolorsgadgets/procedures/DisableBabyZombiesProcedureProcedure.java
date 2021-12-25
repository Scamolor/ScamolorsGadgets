package net.hyperzone.scamolorsgadgets.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.hyperzone.scamolorsgadgets.world.DisableBabyZombiesGameRule;
import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsMod;

import java.util.Map;
import java.util.HashMap;

public class DisableBabyZombiesProcedureProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntitySpawned(EntityJoinWorldEvent event) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency world for procedure DisableBabyZombiesProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency entity for procedure DisableBabyZombiesProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.getWorldInfo().getGameRulesInstance().getBoolean(DisableBabyZombiesGameRule.gamerule) == true) {
			if (entity instanceof ZombieEntity == true) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).isChild() : false) == true
						&& (entity instanceof LivingEntity
								? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.UNDEAD)
								: false) == true
						&& world.getWorldInfo().getGameRulesInstance().getBoolean(DisableBabyZombiesGameRule.gamerule) == true) {
					if (!entity.world.isRemote())
						entity.remove();
				}
			}
			if (entity instanceof HuskEntity == true) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).isChild() : false) == true
						&& (entity instanceof LivingEntity
								? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.UNDEAD)
								: false) == true
						&& world.getWorldInfo().getGameRulesInstance().getBoolean(DisableBabyZombiesGameRule.gamerule) == true) {
					if (!entity.world.isRemote())
						entity.remove();
				}
			}
			if (entity instanceof ZombieVillagerEntity == true) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).isChild() : false) == true
						&& (entity instanceof LivingEntity
								? (((LivingEntity) entity).getCreatureAttribute() == CreatureAttribute.UNDEAD)
								: false) == true
						&& world.getWorldInfo().getGameRulesInstance().getBoolean(DisableBabyZombiesGameRule.gamerule) == true) {
					if (!entity.world.isRemote())
						entity.remove();
				}
			}
		}
	}
}
