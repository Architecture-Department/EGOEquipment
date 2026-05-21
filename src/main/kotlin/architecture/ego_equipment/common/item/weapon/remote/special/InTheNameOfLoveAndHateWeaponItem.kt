package architecture.ego_equipment.common.item.weapon.remote.special

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import architecture.ego_equipment.core.EGOEquipment
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.Projectile
import software.bernie.geckolib.model.GeoModel

class InTheNameOfLoveAndHateWeaponItem : RemoteEgoWeaponGeoItem {
	companion object {
		val STANDBY: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.standby")
		val GALLOP: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.gallop")
		val NORMAL_SHOOTING: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.normal_shooting")
		val NORMAL_SHOOTING1: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.normal_shooting.1")
		val NORMAL_SHOOTING2: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.normal_shooting.2")
		val SKILL: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.skill")
		val SKILL1: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.skill.1")
		val SKILL2: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.skill.2")
		val FINISHING_SKILL: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill")
		val FINISHING_SKILL1: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.1")
		val FINISHING_SKILL2: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.2")
		val FINISHING_SKILL3: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.3")
		val FINISHING_SKILL4: ResourceLocation = EGOEquipment.modRl("in_the_name_of_love_and_hate_weapon.finishing_skill.4")
	}

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

	override fun shootProjectile(
		shooterEntity: LivingEntity, projectileEntity: Projectile, projectileIndex: Int,
		projectileVelocity: Float, projectileInaccuracy: Float, shootingAngle: Float, targetEntity: LivingEntity?
	) {
	}
}
