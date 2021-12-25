
package net.hyperzone.scamolorsgadgets.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsModElements;

@ScamolorsGadgetsModElements.ModElement.Tag
public class DragonAshPickaxeItem extends ScamolorsGadgetsModElements.ModElement {
	@ObjectHolder("scamolors_gadgets:dragon_ash_pickaxe")
	public static final Item block = null;

	public DragonAshPickaxeItem(ScamolorsGadgetsModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 40600;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 18;
			}

			public int getEnchantability() {
				return 40;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ProtostarDustItem.block));
			}
		}, 1, -2.6f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("dragon_ash_pickaxe"));
	}
}
