package architecture.ego_equipment.common.item.weapon.remote.gun;

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PistolEgoWeaponItem extends GunEgoWeaponItem {
	public PistolEgoWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public PistolEgoWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, ResourceLocation modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}
