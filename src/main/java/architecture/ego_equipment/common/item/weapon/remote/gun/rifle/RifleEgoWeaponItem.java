package architecture.ego_equipment.common.item.weapon.remote.gun.rifle;

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem;
import architecture.ego_equipment.common.item.weapon.remote.gun.GunEgoWeaponItem;
import software.bernie.geckolib.model.GeoModel;

public class RifleEgoWeaponItem extends GunEgoWeaponItem {

	public RifleEgoWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public RifleEgoWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, String modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}
