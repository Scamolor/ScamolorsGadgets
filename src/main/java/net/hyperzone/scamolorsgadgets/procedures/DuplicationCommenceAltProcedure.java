package net.hyperzone.scamolorsgadgets.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;

import net.hyperzone.scamolorsgadgets.ScamolorsGadgetsMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class DuplicationCommenceAltProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency world for procedure DuplicationCommenceAlt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency x for procedure DuplicationCommenceAlt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency y for procedure DuplicationCommenceAlt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ScamolorsGadgetsMod.LOGGER.warn("Failed to load dependency z for procedure DuplicationCommenceAlt!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		ItemStack clonestack = ItemStack.EMPTY;
		double energy = 0;
		clonestack = (new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))), (int) (0)));
		if (new Object() {
			public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y)), (int) (Math.floor(z))), (int) 155) == 155) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (Math.floor(x) + 1), (int) (Math.floor(y)), (int) (Math.floor(z))));
				int _amount = (int) 155;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))));
				if (_ent != null) {
					final int _sltid = (int) (1);
					final ItemStack _setstack = (clonestack);
					_setstack.setCount((int) (1 + new Object() {
						public int getAmount(IWorld world, BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))), (int) (1))));
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
		} else {
			if (new Object() {
				public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
					return _retval.get();
				}
			}.extractEnergySimulate(world, new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y)), (int) (Math.floor(z))), (int) 155) == 155) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) (Math.floor(x) - 1), (int) (Math.floor(y)), (int) (Math.floor(z))));
					int _amount = (int) 155;
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = (clonestack);
						_setstack.setCount((int) (1 + new Object() {
							public int getAmount(IWorld world, BlockPos pos, int sltid) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).getCount());
									});
								}
								return _retval.get();
							}
						}.getAmount(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))), (int) (1))));
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
			} else {
				if (new Object() {
					public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null)
									.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
						return _retval.get();
					}
				}.extractEnergySimulate(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y) + 1), (int) (Math.floor(z))),
						(int) 155) == 155) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y) + 1), (int) (Math.floor(z))));
						int _amount = (int) 155;
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))));
						if (_ent != null) {
							final int _sltid = (int) (1);
							final ItemStack _setstack = (clonestack);
							_setstack.setCount((int) (1 + new Object() {
								public int getAmount(IWorld world, BlockPos pos, int sltid) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null) {
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).getCount());
										});
									}
									return _retval.get();
								}
							}.getAmount(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))), (int) (1))));
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
								}
							});
						}
					}
				} else {
					if (new Object() {
						public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null)
										.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
							return _retval.get();
						}
					}.extractEnergySimulate(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y) - 1), (int) (Math.floor(z))),
							(int) 155) == 155) {
						{
							TileEntity _ent = world
									.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y) - 1), (int) (Math.floor(z))));
							int _amount = (int) 155;
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
						}
						{
							TileEntity _ent = world.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))));
							if (_ent != null) {
								final int _sltid = (int) (1);
								final ItemStack _setstack = (clonestack);
								_setstack.setCount((int) (1 + new Object() {
									public int getAmount(IWorld world, BlockPos pos, int sltid) {
										AtomicInteger _retval = new AtomicInteger(0);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).getCount());
											});
										}
										return _retval.get();
									}
								}.getAmount(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))), (int) (1))));
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
					} else {
						if (new Object() {
							public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
								return _retval.get();
							}
						}.extractEnergySimulate(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z) + 1)),
								(int) 155) == 155) {
							{
								TileEntity _ent = world
										.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z) + 1)));
								int _amount = (int) 155;
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> capability.extractEnergy(_amount, false));
							}
							{
								TileEntity _ent = world
										.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))));
								if (_ent != null) {
									final int _sltid = (int) (1);
									final ItemStack _setstack = (clonestack);
									_setstack.setCount((int) (1 + new Object() {
										public int getAmount(IWorld world, BlockPos pos, int sltid) {
											AtomicInteger _retval = new AtomicInteger(0);
											TileEntity _ent = world.getTileEntity(pos);
											if (_ent != null) {
												_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
													_retval.set(capability.getStackInSlot(sltid).getCount());
												});
											}
											return _retval.get();
										}
									}.getAmount(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
											(int) (1))));
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
										}
									});
								}
							}
						} else {
							if (new Object() {
								public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
									AtomicInteger _retval = new AtomicInteger(0);
									TileEntity _ent = world.getTileEntity(pos);
									if (_ent != null)
										_ent.getCapability(CapabilityEnergy.ENERGY, null)
												.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
									return _retval.get();
								}
							}.extractEnergySimulate(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z) - 1)),
									(int) 155) == 155) {
								{
									TileEntity _ent = world
											.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z) - 1)));
									int _amount = (int) 155;
									if (_ent != null)
										_ent.getCapability(CapabilityEnergy.ENERGY, null)
												.ifPresent(capability -> capability.extractEnergy(_amount, false));
								}
								{
									TileEntity _ent = world
											.getTileEntity(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))));
									if (_ent != null) {
										final int _sltid = (int) (1);
										final ItemStack _setstack = (clonestack);
										_setstack.setCount((int) (1 + new Object() {
											public int getAmount(IWorld world, BlockPos pos, int sltid) {
												AtomicInteger _retval = new AtomicInteger(0);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).getCount());
													});
												}
												return _retval.get();
											}
										}.getAmount(world, new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
												(int) (1))));
										_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											if (capability instanceof IItemHandlerModifiable) {
												((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
											}
										});
									}
								}
							} else {
								System.out.println("Insufficient energy or no input!");
							}
						}
					}
				}
			}
		}
	}
}
