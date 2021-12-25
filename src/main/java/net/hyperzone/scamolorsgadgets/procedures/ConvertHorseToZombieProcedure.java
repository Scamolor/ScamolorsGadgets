package net.hyperzone.scamolorsgadgets.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.horse.ZombieHorseEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class ConvertHorseToZombieProcedure {
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
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency world for procedure ConvertHorseToZombie!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency entity for procedure ConvertHorseToZombie!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		double var0 = 0;
		double var1 = 0;
		double yval = 0;
		double zval = 0;
		double xval = 0;
		if (entity instanceof HorseEntity && ((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false) == false
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).isChild() : false) == false
				&& (((world instanceof World) ? ((World) world).isDaytime() : false) == false || world.getWorldInfo().isThundering()
						|| world.getWorldInfo().isRaining())) {
			entity.fallDistance = (float) (0);
			entity.attackEntityFrom(DamageSource.DRAGON_BREATH, (float) 1);
			entity.setFire((int) 10);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 200, (int) 255, (true), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 200, (int) 2, (true), (false)));
			if (new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.BLINDNESS)
								return effect.getDuration();
						}
					}
					return 0;
				}
			}.check(entity) == 1) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).clearActivePotions();
				entity.extinguish();
				entity.setMotionMultiplier(Blocks.AIR.getDefaultState(), new Vector3d(0.25D, (double) 0.05F, 0.25D));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20000000, (int) 255, (true), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 20000000, (int) 255, (true), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 20000000, (int) 255, (true), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 20000000, (int) 255, (true), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) 20000000, (int) 255, (true), (false)));
				entity.setMotion(0, 0, 0);
				entity.setMotion(0, 0, 0);
				entity.setMotion(0, 0, 0);
				entity.setNoGravity((true));
				entity.rotationYaw = (float) (0);
				entity.setRenderYawOffset(entity.rotationYaw);
				entity.prevRotationYaw = entity.rotationYaw;
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
					((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
					((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
				}
				entity.rotationPitch = (float) (0);
				entity.setMotionMultiplier(Blocks.AIR.getDefaultState(), new Vector3d(0.25D, (double) 0.05F, 0.25D));
				entity.fallDistance = (float) (0);
				xval = (entity.getPosX());
				yval = (entity.getPosY());
				zval = (entity.getPosZ());
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) xval, (int) yval, (int) zval, (float) 0, Explosion.Mode.NONE);
				}
				if (world instanceof ServerWorld) {
					LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
					_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) xval, (int) yval, (int) zval)));
					_ent.setEffectOnly(false);
					((World) world).addEntity(_ent);
				}
				entity.fallDistance = (float) (2147483646);
				entity.setAir((int) 0);
				entity.attackEntityFrom(DamageSource.DRYOUT, (float) 2147483646);
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new ZombieHorseEntity(EntityType.ZOMBIE_HORSE, (World) world);
					entityToSpawn.setLocationAndAngles(xval, yval, zval, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, xval, yval, zval, new ItemStack(Items.SADDLE));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
