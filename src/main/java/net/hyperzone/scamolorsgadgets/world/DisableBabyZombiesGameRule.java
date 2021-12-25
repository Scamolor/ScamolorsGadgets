package net.hyperzone.scamolorsgadgets.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsModElements;

import java.lang.reflect.Method;

@ScamolorsGadgetsModElements.ModElement.Tag
public class DisableBabyZombiesGameRule extends ScamolorsGadgetsModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("disableBabyZombies", GameRules.Category.SPAWNING,
			create(false));

	public DisableBabyZombiesGameRule(ScamolorsGadgetsModElements instance) {
		super(instance, 2);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
