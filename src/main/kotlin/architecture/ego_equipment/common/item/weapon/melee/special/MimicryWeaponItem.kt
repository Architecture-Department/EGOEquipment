package architecture.ego_equipment.common.item.weapon.melee.special

import architecture.ego_equipment.common.item.weapon.melee.MeleeEgoWeaponGeoItem
import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.GeoModel

class MimicryWeaponItem : MeleeEgoWeaponGeoItem {
	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
		geoModel: GeoModel<MeleeEgoWeaponGeoItem>,
		guiModel: GeoModel<MeleeEgoWeaponGeoItem>?
	) : super(itemProperties, egoWeaponBuilder, geoModel)

	constructor(
		itemProperties: Properties,
		egoWeaponBuilder: IMeleeEgoWeaponItem.Builder,
		modPath: ResourceLocation
	) : super(itemProperties, egoWeaponBuilder, modPath)
}
