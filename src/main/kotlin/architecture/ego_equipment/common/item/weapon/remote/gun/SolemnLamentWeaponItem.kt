package architecture.ego_equipment.common.item.weapon.remote.gun

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.EGOEquipmentParticleTypes
import architecture.ego_equipment.init.EGOEquipmentSoundEvents
import architecture.goldenboughs_lib.api.LcDamageType
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import architecture.goldenboughs_lib.init.LibDamageSources
import architecture.goldenboughs_lib.util.LcDamageTypeUtil.getLcDamageType
import architecture.goldenboughs_lib.util.LcLevelUtil.getLevel
import net.minecraft.core.particles.SimpleParticleType
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import net.minecraft.sounds.SoundEvent
import net.minecraft.util.Mth
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.ProjectileUtil
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.ClipContext
import net.minecraft.world.phys.EntityHitResult
import net.minecraft.world.phys.HitResult
import software.bernie.geckolib.model.GeoModel

class SolemnLamentWeaponItem : GunEgoWeaponItem {
	companion object {
		val STANDBY: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.standby")
		val GALLOP: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.gallop")
		val SHOOTING: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.shooting")
		val SHOOTING1: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.shooting1")
		val SHOOTING2: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.shooting2")
		val SHOOTING3: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.shooting3")
		val TWIN_STANDBY: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.twin.standby")
		val TWIN_GALLOP: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.twin.gallop")
		val TWIN_SHOOTING: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.twin.shooting")
		val TWIN_SHOOTING1: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.twin.shooting1")
		val TWIN_SHOOTING2: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.twin.shooting2")
		val TWIN_SHOOTING3: ResourceLocation = EGOEquipment.modRl("solemn_lament_weapon.twin.shooting3")
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

	override fun gunShoot(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand): Boolean {
		val isShoot = super.gunShoot(playerEntity, itemStack, handUsed)
		if (!isShoot || playerEntity !is ServerPlayer) {
			return isShoot
		}
		return true
	}

	override fun isOffHandShoot(player: Player, stack: ItemStack): Boolean = true

	override fun notConsumingShoot(
		world: ServerLevel, shooterEntity: LivingEntity, handUsed: InteractionHand, weaponItem: ItemStack,
		projectileVelocity: Float, projectileInaccuracy: Float, targetEntity: LivingEntity?
	) {
		var isBlack = false
		val hitResult = getHitResult(world, shooterEntity, handUsed, weaponItem)

		val lcDamageColorDamageType = weaponItem.getLcDamageType()
		if (hitResult is EntityHitResult) {
			val entity = hitResult.entity
			val damageSources = LibDamageSources.remoteDamage(shooterEntity)
			damageSources.`goldenboughs_lib$setWeaponItem`(weaponItem)
			damageSources.`goldenboughs_lib$setDamageLevel`(weaponItem.getLevel())
			damageSources.`goldenboughs_lib$setLcDamageType`(lcDamageColorDamageType)
			entity.hurt(damageSources, getDamage(shooterEntity, weaponItem, handUsed))
		}

		if (lcDamageColorDamageType == LcDamageType.EROSION) {
			isBlack = true
		}

		val particleType: SimpleParticleType =
			(if (isBlack) EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_BLACK else EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_WHITE).get()
		val hitResultLocationPos = hitResult.location
		val random = shooterEntity.random

		val position = shooterEntity.position()
		val soundEvent: SoundEvent =
			(if (isBlack) EGOEquipmentSoundEvents.SOLEMN_LAMENT_WEAPON_ATTACK_BLACK else EGOEquipmentSoundEvents.SOLEMN_LAMENT_WEAPON_ATTACK_WHITE).value()
		world.playSound(
			null,
			position.x,
			position.y,
			position.z,
			soundEvent,
			shooterEntity.soundSource,
			0.1f + 1 * random.nextFloat(),
			0.1f + 1 * random.nextFloat()
		)

		val count = Math.max(3, (5 * random.nextFloat()).toInt())
		for (i in 0 until count) {
			world.sendParticles(
				particleType,
				hitResultLocationPos.x,
				hitResultLocationPos.y,
				hitResultLocationPos.z,
				1,
				random.nextFloat() * 0.25,
				random.nextFloat() * 0.25,
				random.nextFloat() * 0.25,
				0.0
			)
		}
	}

	private fun getHitResult(
		world: ServerLevel,
		shooterEntity: LivingEntity,
		handUsed: InteractionHand,
		weaponItem: ItemStack
	): HitResult {
		val distance = getProjectileRange(shooterEntity, weaponItem, handUsed)
		val from = shooterEntity.getEyePosition(1.0f)
		val vec31 = shooterEntity.getViewVector(1.0f)
		val to = from.add(vec31.x * distance, vec31.y * distance, vec31.z * distance)
		val aabb = shooterEntity.boundingBox.expandTowards(vec31.scale(distance.toDouble())).inflate(1.0, 1.0, 1.0)

		var hitResult: HitResult? = ProjectileUtil.getEntityHitResult(
			shooterEntity,
			from,
			to,
			aabb,
			{ entity -> !entity.isSpectator && entity.isPickable },
			Mth.square(distance.toDouble())
		)

		if (hitResult is EntityHitResult) {
			val entity = hitResult.entity
			if (!entity.isAlive || entity.uuid == shooterEntity.uuid) {
				hitResult = null
			}
		}

		if (hitResult == null || hitResult.type == HitResult.Type.MISS) {
			hitResult = world.clip(ClipContext(from, to, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, shooterEntity))
		}

		return hitResult
	}
}
