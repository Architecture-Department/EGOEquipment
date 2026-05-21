package architecture.ego_equipment.common.item.weapon.remote.cannon

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import architecture.ego_equipment.common.item.weapon.remote.gun.GunEgoWeaponItem
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.GeoModel

class CannonEgoWeaponItem : GunEgoWeaponItem {
	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IRemoteEgoWeaponItem.Builder,
		geoModel: GeoModel<RemoteEgoWeaponGeoItem>,
		guiModel: GeoModel<RemoteEgoWeaponGeoItem>?
	) : super(itemProperties, egoWeaponBuilder, geoModel, guiModel)

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IRemoteEgoWeaponItem.Builder,
		modPath: ResourceLocation
	) : super(itemProperties, egoWeaponBuilder, modPath)
}
