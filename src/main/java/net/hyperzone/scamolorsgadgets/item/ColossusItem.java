
package net.hyperzone.scamolorsgadgets.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.Blocks;

import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsModElements;

import java.util.List;

@ScamolorsGadgetsModElements.ModElement.Tag
public class ColossusItem extends ScamolorsGadgetsModElements.ModElement {
	@ObjectHolder("scamolors_gadgets:colossus")
	public static final Item block = null;

	public ColossusItem(ScamolorsGadgetsModElements instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 49770;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 65335;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.QUARTZ), new ItemStack(Blocks.LAVA), new ItemStack(Blocks.WATER),
						new ItemStack(Blocks.MOVING_PISTON), new ItemStack(Blocks.PISTON_HEAD), new ItemStack(Blocks.SOUL_FIRE),
						new ItemStack(Blocks.FIRE), new ItemStack(Blocks.BUBBLE_COLUMN), new ItemStack(Blocks.DAYLIGHT_DETECTOR),
						new ItemStack(Blocks.ATTACHED_PUMPKIN_STEM), new ItemStack(Blocks.ATTACHED_MELON_STEM), new ItemStack(Blocks.MELON_STEM),
						new ItemStack(Blocks.BEETROOTS), new ItemStack(Blocks.PUMPKIN_STEM), new ItemStack(Blocks.SPAWNER),
						new ItemStack(Blocks.REDSTONE_LAMP), new ItemStack(Blocks.CAVE_AIR), new ItemStack(Blocks.VOID_AIR),
						new ItemStack(Blocks.END_GATEWAY), new ItemStack(Blocks.NETHER_PORTAL), new ItemStack(ColossusItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Mines anything"));
				list.add(new StringTextComponent("but is very slow"));
			}
		}.setRegistryName("colossus"));
	}
}
