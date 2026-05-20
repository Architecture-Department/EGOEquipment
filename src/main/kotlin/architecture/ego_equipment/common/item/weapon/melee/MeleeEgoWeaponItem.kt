package architecture.ego_equipment.common.item.weapon.melee

import architecture.ego_equipment.common.item.weapon.EgoWeaponItem
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem

abstract class MeleeEgoWeaponItem(
	itemProperties: Properties,
	egoWeaponBuilder: IMeleeEgoWeaponItem.Builder
) : EgoWeaponItem(itemProperties, egoWeaponBuilder), IMeleeEgoWeaponItem
