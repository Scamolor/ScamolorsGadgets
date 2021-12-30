
package net.hyperzone.scamolorsgadgets.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IWorldReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.MobEntity;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.hyperzone.scamolorsgadgets.itemgroup.ScamolorGadgetsItemGroup;
import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsModElements;

import java.util.List;
import java.util.Collections;

@ScamolorsGadgetsModElements.ModElement.Tag
public class FleroviumBlockBlock extends ScamolorsGadgetsModElements.ModElement {
	@ObjectHolder("scamolors_gadgets:flerovium_block")
	public static final Block block = null;

	public FleroviumBlockBlock(ScamolorsGadgetsModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ScamolorGadgetsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(300f, 10100f).setLightLevel(s -> 1)
					.harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool().slipperiness(0.3f).setNeedsPostProcessing((bs, br, bp) -> true)
					.setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("flerovium_block");
		}

		@Override
		public float[] getBeaconColorMultiplier(BlockState state, IWorldReader world, BlockPos pos, BlockPos beaconPos) {
			return new float[]{0.305882352941f, 0.149019607843f, 0.878431372549f};
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
			return 2.1f;
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.LAPIS;
		}

		@Override
		public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
			return PathNodeType.BLOCKED;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
