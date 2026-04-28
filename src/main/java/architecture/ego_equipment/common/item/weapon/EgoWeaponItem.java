package architecture.ego_equipment.common.item.weapon;

import architecture.goldenboughs_lib.api.LcDamageType;
import architecture.goldenboughs_lib.api.capability.item.IItemLcDamageType;
import architecture.goldenboughs_lib.api.capability.item.IItemUsageReq;
import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * EGO武器
 */
public abstract class EgoWeaponItem extends Item implements IEgoWeaponItem, IItemUsageReq, IItemLcDamageType {
	private final @Nullable LcDamageType lcDamageType;
	private final Set<LcDamageType> canCauseLcDamageTypes;

	public EgoWeaponItem(Properties itemProperties, Builder<?> builder) {
		super(IEgoWeaponItem.add(itemProperties, builder));
		this.lcDamageType = builder.lcDamageType;
		this.canCauseLcDamageTypes = builder.canCauseLcDamageTypes;
	}

	/// 是否可以挖掘方块
	@Override
	public boolean canAttackBlock(@NotNull BlockState blockState, @NotNull Level world, @NotNull BlockPos blockPosition, Player playerEntity) {
		return !playerEntity.isCreative();
	}

	@Override
	public @Nullable LcDamageType getLcDamageType(ItemStack stack) {
		return lcDamageType;
	}

	@Override
	public @NotNull Set<LcDamageType> getCanCauseLcDamageTypes(ItemStack stack) {
		return canCauseLcDamageTypes;
	}
}
