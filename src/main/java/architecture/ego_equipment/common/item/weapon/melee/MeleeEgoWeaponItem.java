package architecture.ego_equipment.common.item.weapon.melee;

import architecture.ego_equipment.common.item.weapon.EgoWeaponItem;
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;

public abstract class MeleeEgoWeaponItem extends EgoWeaponItem implements IMeleeEgoWeaponItem {

	public MeleeEgoWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder) {
		super(itemProperties, egoWeaponBuilder);
	}
}
