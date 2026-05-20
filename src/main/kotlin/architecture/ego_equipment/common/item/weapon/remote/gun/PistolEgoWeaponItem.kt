package architecture.ego_equipment.common.item.weapon.remote.gun

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.GeoModel

class PistolEgoWeaponItem : GunEgoWeaponItem {
	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: Builder,
		geoModel: GeoModel<RemoteEgoWeaponGeoItem>,
		guiModel: GeoModel<RemoteEgoWeaponGeoItem>?
	) : super(itemProperties, egoWeaponBuilder, geoModel, guiModel)

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: Builder,
		modPath: ResourceLocation
	) : super(itemProperties, egoWeaponBuilder, modPath)
}
