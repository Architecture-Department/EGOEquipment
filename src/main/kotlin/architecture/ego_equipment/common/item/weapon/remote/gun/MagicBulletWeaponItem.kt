package architecture.ego_equipment.common.item.weapon.remote.gun

import architecture.ego_equipment.common.entity.projectile.MagicBulletEntity
import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import architecture.goldenboughs_lib.util.GunWeaponUtil
import architecture.goldenboughs_lib.util.PiercingUtil
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import software.bernie.geckolib.model.GeoModel

class MagicBulletWeaponItem : GunEgoWeaponItem {
	companion object {
		val STANDBY: ResourceLocation = EGOEquipmentConstants.modRl("magic_bullet_weapon.standby")
		val GALLOP: ResourceLocation = EGOEquipmentConstants.modRl("magic_bullet_weapon.gallop")
		val SHOOTING: ResourceLocation = EGOEquipmentConstants.modRl("magic_bullet_weapon.shooting")
		val SHOOTING_AIM: ResourceLocation = EGOEquipmentConstants.modRl("magic_bullet_weapon.shooting.aim")
		val SHOOTING_AIM_CYCLE: ResourceLocation = EGOEquipmentConstants.modRl("magic_bullet_weapon.shooting.aim.cycle")
		val SHOOTING_AIM_LAUNCH: ResourceLocation = EGOEquipmentConstants.modRl("magic_bullet_weapon.shooting.aim.launch")
		val SHOOTING_AIM_TERMINATE: ResourceLocation =
			EGOEquipmentConstants.modRl("magic_bullet_weapon.shooting.aim.terminate")
		val SHOOTING_AIM_CHARGEUP: ResourceLocation =
			EGOEquipmentConstants.modRl("magic_bullet_weapon.shooting.aim.chargeup")
		val SHOOTING_CYCLE: ResourceLocation = EGOEquipmentConstants.modRl("magic_bullet_weapon.shooting.cycle")
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

	override fun use(world: Level, playerEntity: Player, handUsed: InteractionHand): InteractionResultHolder<ItemStack> {
		if (handUsed != InteractionHand.MAIN_HAND) {
			return InteractionResultHolder.pass(playerEntity.getItemInHand(handUsed))
		}
		return super.use(world, playerEntity, handUsed)
	}

	override fun gunShoot(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand): Boolean {
		val isShoot = super.gunShoot(playerEntity, itemStack, handUsed)
		if (isShoot && playerEntity is ServerPlayer) {
		}
		return isShoot
	}

	override fun gunAimShootExecute(
		playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand, chargeUpPercentage: Float
	): Boolean {
		if (playerEntity.level() !is ServerLevel) {
			return true
		}
		super.gunAimShootExecute(playerEntity, itemStack, handUsed, chargeUpPercentage)
		GunWeaponUtil.resetChargeUp(playerEntity, handUsed)
		return true
	}

	override fun gunAim(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand) {
		super.gunAim(playerEntity, itemStack, handUsed)
		if (playerEntity is ServerPlayer) {
		}
	}

	override fun isGunAim(player: Player, itemStack: ItemStack): Boolean = true

	override fun gunEndAim(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand) {
		if (playerEntity !is ServerPlayer) {
			return
		}
		super.gunEndAim(playerEntity, itemStack, handUsed)
	}

	override fun getProjectileFactory(): ProjectileFactory = ProjectileFactory { level, shooter, itemStack, handUsed ->
		val magicBullet = MagicBulletEntity(level, shooter)
		val damage = getDamage(shooter, itemStack, handUsed)
		magicBullet.setDamage(damage)
		PiercingUtil.setPiercingDefault(magicBullet, damage)
		magicBullet
	}
}
