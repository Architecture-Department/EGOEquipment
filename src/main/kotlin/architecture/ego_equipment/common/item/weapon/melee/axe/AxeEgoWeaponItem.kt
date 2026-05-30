package architecture.ego_equipment.common.item.weapon.melee.axe

import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem
import architecture.goldenboughs_lib.module.lc_damage.api.LcDamageType
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Tier

class AxeEgoWeaponItem(
	tier: Tier,
	itemProperties: Properties,
	builder: IMeleeEgoWeaponItem.Builder
) : AxeItem(tier, IEgoWeaponItem.add(itemProperties, builder)), IMeleeEgoWeaponItem {
	private val lcDamageType: LcDamageType? = builder.lcDamageType
	private val canCauseLcDamageTypes: Set<LcDamageType> = builder.canCauseLcDamageTypes

	override fun getLcDamageType(stack: ItemStack): LcDamageType? = lcDamageType
	override fun getCanCauseLcDamageTypes(stack: ItemStack): Set<LcDamageType> = canCauseLcDamageTypes
}
