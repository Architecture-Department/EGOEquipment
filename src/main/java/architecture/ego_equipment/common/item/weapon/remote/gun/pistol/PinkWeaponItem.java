package architecture.ego_equipment.common.item.weapon.remote.gun.pistol;

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem;
import architecture.ego_equipment.common.item.weapon.remote.gun.GunEgoWeaponItem;
import software.bernie.geckolib.model.GeoModel;

public class PinkWeaponItem extends GunEgoWeaponItem {

	public PinkWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public PinkWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, String modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}
