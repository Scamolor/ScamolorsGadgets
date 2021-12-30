package net.hyperzone.scamolorsgadgets.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;

import net.hyperzone.scamolorsgadgets.item.CrystalOfUndyingItem;
import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class EffectHealProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency world for procedure EffectHeal!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency x for procedure EffectHeal!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency y for procedure EffectHeal!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency z for procedure EffectHeal!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency entity for procedure EffectHeal!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EffectHeal!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (entity instanceof PlayerEntity) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 4) {
				if (world.isRemote()) {
					Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(CrystalOfUndyingItem.block));
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.UNLUCK);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.NAUSEA);
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.BLINDNESS);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 20, (int) 40, (false), (false)));
				entity.fallDistance = (float) (0);
				entity.setSprinting((false));
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).addExhaustion((float) 0.4);
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).addExperienceLevel(-((int) 5));
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ())),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager()
							.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "execute at @");
				}
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (sourceentity instanceof MonsterEntity) {
							sourceentity.setAir((int) 0);
							sourceentity.setMotionMultiplier(Blocks.AIR.getDefaultState(), new Vector3d(0.25D, (double) 0.05F, 0.25D));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.UNLUCK, (int) 60, (int) 5, (false), (false)));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 60, (int) 5, (false), (false)));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 60, (int) 5, (false), (false)));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 5, (false), (false)));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 60, (int) 5, (false), (false)));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 60, (int) 5, (false), (false)));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 3, (false), (false)));
							if (sourceentity instanceof LivingEntity)
								((LivingEntity) sourceentity)
										.addPotionEffect(new EffectInstance(Effects.WITHER, (int) 60, (int) 2, (false), (false)));
							if (sourceentity instanceof LivingEntity) {
								((LivingEntity) sourceentity).attackEntityFrom(new DamageSource("pulse").setDamageBypassesArmor(), (float) 1);
							}
							sourceentity.setMotionMultiplier(Blocks.AIR.getDefaultState(), new Vector3d(0.25D, (double) 0.05F, 0.25D));
							if (sourceentity instanceof LivingEntity) {
								((LivingEntity) sourceentity).removePotionEffect(Effects.SPEED);
							}
						}
					}
				}
			}
		}
	}
}
