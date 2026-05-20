package architecture.ego_equipment.common.item.weapon

import architecture.goldenboughs_lib.api.LcDamageType
import architecture.goldenboughs_lib.api.capability.item.IItemLcDamageType
import architecture.goldenboughs_lib.api.capability.item.IItemUsageReq
import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem
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
