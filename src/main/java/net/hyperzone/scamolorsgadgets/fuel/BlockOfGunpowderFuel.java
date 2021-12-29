
package net.hyperzone.scamolorsgadgets.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.hyperzone.scamolorsgadgets.block.CompressedGunpowderBlock;

@Mod.EventBusSubscriber
public class BlockOfGunpowderFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == CompressedGunpowderBlock.block.asItem())
			event.setBurnTime(8000);
	}
}
