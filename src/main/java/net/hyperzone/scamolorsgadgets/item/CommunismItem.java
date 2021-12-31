
package net.hyperzone.scamolorsgadgets.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import net.hyperzone.scamolorsgadgets.itemgroup.ScamolorGadgetsItemGroup;
import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsModElements;

@ScamolorsGadgetsModElements.ModElement.Tag
public class CommunismItem extends ScamolorsGadgetsModElements.ModElement {
	@ObjectHolder("scamolors_gadgets:communism")
	public static final Item block = null;

	public CommunismItem(ScamolorsGadgetsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ScamolorsGadgetsModElements.sounds.get(new ResourceLocation("scamolors_gadgets:soviet")),
					new Item.Properties().group(ScamolorGadgetsItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("communism");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
