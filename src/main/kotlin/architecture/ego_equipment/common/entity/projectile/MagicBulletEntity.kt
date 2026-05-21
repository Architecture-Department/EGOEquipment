package architecture.ego_equipment.common.entity.projectile

import architecture.ego_equipment.init.EGOEquipmentProjectileEntityTypes
import architecture.goldenboughs_lib.common.entiy.projectile.BulletEntity
import architecture.goldenboughs_lib.init.LibDamageSources
import architecture.goldenboughs_lib.init.LibDamageTypes
import architecture.goldenboughs_lib.util.PiercingUtil
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.level.Level
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.EntityHitResult

class MagicBulletEntity : BulletEntity {
	private var damage: Float = 0f
	private var target: LivingEntity? = null
	private var flyingTicks: Int = 0

	constructor(entityType: EntityType<out BulletEntity>, level: Level) : super(entityType, level) {
		isNoGravity = true
	}

	constructor(level: Level, shooter: LivingEntity) : super(
		EGOEquipmentProjectileEntityTypes.MAGIC_BULLET_ENTITY.get(), shooter, level
	) {
		isNoGravity = true
	}

	companion object {
		private const val MAX_FLIGHT_TICK = 100

		@JvmStatic
		fun create(level: Level, shooter: LivingEntity, damage: Float, target: LivingEntity): MagicBulletEntity {
			val entity = MagicBulletEntity(level, shooter)
			entity.owner = shooter
			entity.damage = damage
			entity.target = target
			return entity
		}

		@JvmStatic
		fun createWithDefaultPiercing(
			level: Level,
			shooter: LivingEntity,
			damage: Float,
			target: LivingEntity
		): MagicBulletEntity =
			createWithPiercing(level, shooter, damage, target, -1, 0.75f, true)

		@JvmStatic
		fun createWithPiercing(
			level: Level, shooter: LivingEntity, damage: Float, target: LivingEntity,
			maxPierce: Int, damageDecay: Float, wallPassThrough: Boolean
		): MagicBulletEntity {
			val entity = MagicBulletEntity(level, shooter)
			entity.owner = shooter
			entity.damage = damage
			entity.target = target

			val config = PiercingUtil.PierceData()
				.maxPierce(maxPierce)
				.damageDecay(damageDecay)
				.wallPassThrough(wallPassThrough)
				.originalDamage(damage)

			PiercingUtil.addPiercingTag(entity, config)
			return entity
		}
	}

	fun getDamage(): Float = damage
	fun setDamage(damage: Float) {
		this.damage = damage
	}

	fun getTarget(): LivingEntity? = target
	fun setTarget(target: LivingEntity) {
		this.target = target
	}

	override fun tick() {
		val config = PiercingUtil.getPiercingConfig(this)
		if (config != null && config.isWallPassThroughEnabled) {
			noPhysics = true
		}
		flyingTicks++

		if (damage < 0.0f || flyingTicks > MAX_FLIGHT_TICK) {
			setDead()
			return
		}

		val oPos = onPos
		super.tick()
		val t = target ?: return
		val nPos = onPos
		val tPos = t.onPos

		if (oPos.distSqr(tPos) > nPos.distSqr(tPos)) {
			correctTrajectory()
		}
	}

	protected fun correctTrajectory() {
		val t = target
		if (t == null) {
			setDead()
			return
		}

		val vec = getViewVector(1f).reverse()
		val pos = t.getPosition(1f).add(vec.scale(3.0))
		setPos(pos)
	}

	protected fun setDead() {
		discard()
	}

	override fun onHitBlock(result: BlockHitResult) {
		val config = PiercingUtil.getPiercingConfig(this)
		if (config != null && config.isWallPassThroughEnabled) {
			return
		}
		super.onHitBlock(result)
	}

	override fun onHitEntity(result: EntityHitResult) {
		val target = result.entity
		val owner = owner

		val damageSource = LibDamageSources.createDamage(
			level().registryAccess(),
			LibDamageTypes.REMOTE,
			this,
			owner,
			position()
		)

		target.hurt(damageSource, damage)

		if (!PiercingUtil.hasPiercingTag(this)) {
			super.onHitEntity(result)
		}
	}

	override fun defineSynchedData(builder: SynchedEntityData.Builder) {
		super.defineSynchedData(builder)
	}
}
