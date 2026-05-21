package architecture.ego_equipment.common.item.weapon.remote.gun

import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import architecture.goldenboughs_lib.api.DelayTaskHolder
import architecture.goldenboughs_lib.api.world.item.IGunWeapon
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import architecture.goldenboughs_lib.util.GunWeaponUtil
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import software.bernie.geckolib.model.GeoModel

abstract class GunEgoWeaponItem : RemoteEgoWeaponGeoItem, IGunWeapon {

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

	companion object {
		@JvmStatic
		protected fun gunShootTickRun(
			tick: Int,
			gunShootExecuteTick: Int,
			maxTick: Int,
			playerEntity: Player,
			itemStack: ItemStack,
			handUsed: InteractionHand
		): Int {
			val value = gunShootExecuteTick / maxTick
			GunWeaponUtil.modifyChargeUpValue(playerEntity, value, handUsed)
			return tick + 1
		}
	}

	override fun use(world: Level, playerEntity: Player, handUsed: InteractionHand): InteractionResultHolder<ItemStack> {
		val itemStack = playerEntity.getItemInHand(handUsed)
		if (!isGunAim(playerEntity, itemStack) || !isOffHandShoot(
				playerEntity,
				itemStack
			) && handUsed == InteractionHand.OFF_HAND
		) {
			return InteractionResultHolder.pass(itemStack)
		}

		gunAim(playerEntity, itemStack, handUsed)
		playerEntity.startUsingItem(handUsed)
		DelayTaskHolder.of(playerEntity).removeTask(handUsed)

		return InteractionResultHolder.success(itemStack)
	}

	override fun isOffHandShoot(player: Player, stack: ItemStack): Boolean = false

	override fun isGunAim(player: Player, itemStack: ItemStack): Boolean = false

	protected fun gunAim(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand) {
		GunWeaponUtil.resetChargeUp(playerEntity, handUsed)
		GunWeaponUtil.setIsAttack(playerEntity, true, handUsed)
	}

	override fun onUseTick(world: Level, usingEntity: LivingEntity, itemStack: ItemStack, remainingUseDuration: Int) {
		if (usingEntity is ServerPlayer) {
			GunWeaponUtil.modifyChargeUpValue(usingEntity, 1, usingEntity.usedItemHand)
		}
	}

	override fun onStopUsing(stack: ItemStack, entity: LivingEntity, count: Int) {
		onStopUsing(stack, entity)
	}

	protected fun onStopUsing(stack: ItemStack, entity: LivingEntity) {
		if (entity !is ServerPlayer) {
			return
		}
		if (isGunAim(entity, stack)) {
			gunEndAim(entity, stack, entity.usedItemHand)
		}
	}

	protected fun gunEndAim(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand) {
		GunWeaponUtil.setIsAttack(playerEntity, true, handUsed)
		GunWeaponUtil.resetChargeUp(playerEntity, handUsed)
	}

	override fun finishUsingItem(stack: ItemStack, level: Level, livingEntity: LivingEntity): ItemStack {
		onStopUsing(stack, livingEntity)
		return super.finishUsingItem(stack, level, livingEntity)
	}

	override fun releaseUsing(stack: ItemStack, level: Level, livingEntity: LivingEntity, timeCharged: Int) {
		onStopUsing(stack, livingEntity)
	}

	override fun isGunAimMove(player: Player, itemStack: ItemStack): Boolean = true

	override fun gunAimShoot(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand): Boolean {
		val chargeUpPercentage = GunWeaponUtil.getChargeUpPercentage(playerEntity, handUsed)
		if (!gunBasEAimShootCondition(playerEntity, itemStack, handUsed, chargeUpPercentage)) {
			return false
		}
		return gunAimShootExecute(playerEntity, itemStack, handUsed, chargeUpPercentage)
	}

	protected fun gunBasEAimShootCondition(
		playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand, chargeUpPercentage: Float
	): Boolean = chargeUpPercentage >= 1f

	protected fun gunAimShootExecute(
		playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand, chargeUpPercentage: Float
	): Boolean {
		if (playerEntity.level() is ServerLevel) {
			val serverLevel = playerEntity.level() as ServerLevel
			val factory = getProjectileFactory()
			if (factory != null) {
				val projectile = factory.create(serverLevel, playerEntity, itemStack, handUsed)
				shootProjectileDirect(
					serverLevel, playerEntity, handUsed, itemStack, projectile,
					getProjectileVelocity(playerEntity, itemStack, handUsed),
					getProjectileInaccuracy(playerEntity, itemStack, handUsed)
				)
			} else {
				this.notConsumingShoot(
					serverLevel, playerEntity, handUsed, itemStack,
					getProjectileVelocity(playerEntity, itemStack, handUsed),
					getProjectileInaccuracy(playerEntity, itemStack, handUsed), null
				)
			}
			GunWeaponUtil.resetChargeUp(playerEntity, handUsed)
		}
		return true
	}

	protected fun shootProjectileDirect(
		level: ServerLevel, shooter: LivingEntity, hand: InteractionHand,
		stack: ItemStack, projectile: Projectile, velocity: Float, inaccuracy: Float
	) {
		projectile.setPos(shooter.x, shooter.eyeY - 0.1, shooter.z)
		shootProjectile(shooter, projectile, 0, velocity, inaccuracy, 0.0F, null)
		level.addFreshEntity(projectile)
		onProjectileShot(stack, shooter, hand, projectile)
	}

	override fun shootProjectile(
		shooter: LivingEntity, projectile: Projectile, index: Int,
		velocity: Float, inaccuracy: Float, angle: Float, target: LivingEntity?
	) {
		projectile.shootFromRotation(shooter, shooter.xRot, shooter.yRot + angle, 0.0F, velocity, inaccuracy)
	}

	protected fun onProjectileShot(
		stack: ItemStack,
		shooter: LivingEntity,
		hand: InteractionHand,
		projectile: Projectile
	) {
	}

	protected fun getProjectileFactory(): ProjectileFactory? = null

	override fun gunShoot(playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand): Boolean {
		val chargeUpPercentage = GunWeaponUtil.getChargeUpPercentage(playerEntity, handUsed)
		if (!gunShootCondition(playerEntity, itemStack, handUsed, chargeUpPercentage)) {
			return false
		}

		if (playerEntity.level() is ServerLevel) {
			val serverLevel = playerEntity.level() as ServerLevel
			val gunShootExecuteTick = gunShootExecuteTick(playerEntity, itemStack, handUsed)
			DelayTaskHolder.of(playerEntity).addTask(
				handUsed, DelayTaskHolder.createTaskBilder()
				.tickRun { tick, maxTick, _ ->
					gunShootTickRun(tick, gunShootExecuteTick, maxTick, playerEntity, itemStack, handUsed)
				}
				.resultRun { gunShootExecute(playerEntity, itemStack, handUsed, serverLevel) }
				.removedTick(gunShootExecuteTick)
				.build())
		}

		GunWeaponUtil.setIsAttack(playerEntity, false, handUsed)
		GunWeaponUtil.resetChargeUp(playerEntity, handUsed)
		return true
	}

	protected fun gunShootExecute(
		playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand, serverLevel: ServerLevel
	): Int {
		val factory = getProjectileFactory()
		if (factory != null) {
			val projectile = factory.create(serverLevel, playerEntity, itemStack, handUsed)
			shootProjectileDirect(
				serverLevel, playerEntity, handUsed, itemStack, projectile,
				getProjectileVelocity(playerEntity, itemStack, handUsed),
				getProjectileInaccuracy(playerEntity, itemStack, handUsed)
			)
		} else {
			this.notConsumingShoot(
				serverLevel, playerEntity, handUsed, itemStack,
				getProjectileVelocity(playerEntity, itemStack, handUsed),
				getProjectileInaccuracy(playerEntity, itemStack, handUsed), null
			)
		}
		GunWeaponUtil.setIsAttack(playerEntity, true, handUsed)
		GunWeaponUtil.resetChargeUp(playerEntity, handUsed)
		return 0
	}

	protected fun gunShootCondition(
		playerEntity: Player, itemStack: ItemStack, handUsed: InteractionHand, chargeUpPercentage: Float
	): Boolean = GunWeaponUtil.isAttack(playerEntity, handUsed)

	override fun gunShootExecuteTick(player: Player, stack: ItemStack, handUsed: InteractionHand): Int =
		GunWeaponUtil.getMaxChargeUpValue(player, handUsed)

	override fun onLeftClickEntity(itemStack: ItemStack, playerEntity: Player, entity: Entity): Boolean = true

	fun interface ProjectileFactory {
		fun create(level: ServerLevel, shooter: LivingEntity, itemStack: ItemStack, handUsed: InteractionHand): Projectile
	}
}
