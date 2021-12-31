package net.hyperzone.scamolorsgadgets.procedures;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsMod;

import java.util.Random;
import java.util.Map;

public class BrokenBlockDestroyedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency entity for procedure BrokenBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack Mainhand = ItemStack.EMPTY;
		double Damage = 0;
		Mainhand = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() instanceof PickaxeItem) {
			Damage = ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getMaxDamage() / 2);
			{
				ItemStack _ist = (Mainhand);
				if (_ist.attemptDamageItem((int) Damage, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
