package architecture.ego_equipment.common.item.weapon.melee.swords;

import architecture.goldenboughs_lib.api.LcDamageType;
import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem;
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class SwordsEgoWeaponItem extends SwordItem implements IMeleeEgoWeaponItem {
	private final @Nullable LcDamageType lcDamageType;
	private final Set<LcDamageType> canCauseLcDamageTypes;

	public SwordsEgoWeaponItem(Tier tier, Properties itemProperties, Builder builder) {
		super(tier, IEgoWeaponItem.add(itemProperties, builder));
		this.lcDamageType = builder.lcDamageType;
		this.canCauseLcDamageTypes = builder.canCauseLcDamageTypes;
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
