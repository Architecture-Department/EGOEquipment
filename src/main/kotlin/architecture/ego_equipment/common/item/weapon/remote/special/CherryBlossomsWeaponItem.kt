package architecture.ego_equipment.common.item.weapon.remote.special

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.Projectile
import software.bernie.geckolib.model.GeoModel

class CherryBlossomsWeaponItem : RemoteEgoWeaponGeoItem {
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

	override fun shootProjectile(
		shooterEntity: LivingEntity, projectileEntity: Projectile, projectileIndex: Int,
		projectileVelocity: Float, projectileInaccuracy: Float, shootingAngle: Float, targetEntity: LivingEntity?
	) {
	}
}
