package architecture.ego_equipment.common.item.weapon.melee.swords

import architecture.goldenboughs_lib.api.LcDamageType
import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.Tier

open class SwordsEgoWeaponItem(
	tier: Tier,
	itemProperties: Properties,
	builder: IMeleeEgoWeaponItem.Builder
) : SwordItem(tier, IEgoWeaponItem.add(itemProperties, builder)), IMeleeEgoWeaponItem {
	private val lcDamageType: LcDamageType? = builder.lcDamageType
	private val canCauseLcDamageTypes: Set<LcDamageType> = builder.canCauseLcDamageTypes

	override fun getLcDamageType(stack: ItemStack): LcDamageType? = lcDamageType
	override fun getCanCauseLcDamageTypes(stack: ItemStack): Set<LcDamageType> = canCauseLcDamageTypes
}
