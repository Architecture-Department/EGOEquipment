package architecture.ego_equipment.common.item.weapon.melee.special;

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem;
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import software.bernie.geckolib.model.GeoModel;

public class JustitiaWeaponItem extends MeleeEgoWeaponGeoItem {

	public JustitiaWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public JustitiaWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, String modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}
