
package net.hyperzone.scamolorsgadgets.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.hyperzone.scamolorsgadgets.item.CommunismItem;
import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsModElements;

@ScamolorsGadgetsModElements.ModElement.Tag
public class ScamolorGadgetsItemGroup extends ScamolorsGadgetsModElements.ModElement {
	public ScamolorGadgetsItemGroup(ScamolorsGadgetsModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabscamolor_gadgets") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CommunismItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
