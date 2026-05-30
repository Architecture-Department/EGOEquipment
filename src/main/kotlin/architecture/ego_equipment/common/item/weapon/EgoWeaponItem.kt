package architecture.ego_equipment.common.item.weapon

import architecture.goldenboughs_lib.api.capability.item.IItemUsageReq
import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem
import architecture.goldenboughs_lib.module.lc_damage.api.LcDamageType
import architecture.goldenboughs_lib.module.lc_damage.capability.IItemLcDamageType
import net.minecraft.core.BlockPos
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState

abstract class EgoWeaponItem : Item, IEgoWeaponItem, IItemUsageReq, IItemLcDamageType {
	private val lcDamageType: LcDamageType?
	private val canCauseLcDamageTypes: Set<LcDamageType>

	constructor(itemProperties: Properties, builder: IEgoWeaponItem.Builder<*>) : super(
		IEgoWeaponItem.add(itemProperties, builder)
	) {
		this.lcDamageType = builder.lcDamageType
		this.canCauseLcDamageTypes = builder.canCauseLcDamageTypes
	}

	override fun canAttackBlock(
		blockState: BlockState,
		world: Level,
		blockPosition: BlockPos,
		playerEntity: Player
	): Boolean =
		!playerEntity.isCreative

	override fun getLcDamageType(stack: ItemStack): LcDamageType? = lcDamageType

	override fun getCanCauseLcDamageTypes(stack: ItemStack): Set<LcDamageType> = canCauseLcDamageTypes
}
