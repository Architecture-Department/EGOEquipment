package architecture.ego_equipment.common.entity.projectile

import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.EGOEquipmentProjectileEntityTypes
import architecture.goldenboughs_lib.api.LcDamageType
import architecture.goldenboughs_lib.api.LcLevel
import architecture.goldenboughs_lib.client.model.entity.GeoEntityModel
import architecture.goldenboughs_lib.init.LibDamageTypes
import architecture.goldenboughs_lib.util.RationalityUtil
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.syncher.SynchedEntityData
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.*
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.phys.Vec3
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.renderer.GeoEntityRenderer
import software.bernie.geckolib.util.GeckoLibUtil

class ParadiseLostSpikeweed(
	entityType: EntityType<*>,
	level: Level
) : Entity(entityType, level), TraceableEntity, GeoEntity {

	private val anims: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)
	private val lifeTicks = 22
	private var owner: LivingEntity? = null
	private var ownerUUID: java.util.UUID? = null
	private var damage: Float = 28f
	private var damage1: Float = 23f
	private var damage2: Float = 20f
	private var clientSideAttackStarted: Boolean = false
	private var targetNumber: Int = 1
	private var isAttack: Boolean = false
	private var targetEntity: LivingEntity? = null

	companion object {
		@JvmStatic
		fun create(
			level: Level,
			x: Double,
			y: Double,
			z: Double,
			targetNumber: Int,
			owner: LivingEntity,
			targetEntity: LivingEntity
		): ParadiseLostSpikeweed {
			val entity = create(level, x, y, z, targetNumber, owner)
			entity.targetEntity = targetEntity
			return entity
		}

		@JvmStatic
		fun create(
			level: Level,
			x: Double,
			y: Double,
			z: Double,
			targetNumber: Int,
			owner: LivingEntity
		): ParadiseLostSpikeweed {
			val entity = ParadiseLostSpikeweed(EGOEquipmentProjectileEntityTypes.PARADISE_LOST_SPIKEWEED.get(), level)
			entity.targetNumber = if (targetNumber == 0) 1 else targetNumber
			entity.setPos(x, y, z)
			entity.owner = owner
			return entity
		}

		@JvmStatic
		fun create(level: Level, vec3: Vec3, targetNumber: Int, owner: LivingEntity): ParadiseLostSpikeweed {
			val entity = ParadiseLostSpikeweed(EGOEquipmentProjectileEntityTypes.PARADISE_LOST_SPIKEWEED.get(), level)
			entity.targetNumber = if (targetNumber == 0) 1 else targetNumber
			entity.setPos(vec3)
			entity.owner = owner
			return entity
		}
	}

	override fun defineSynchedData(builder: SynchedEntityData.Builder) {}

	override fun tick() {
		super.tick()
		if (level().isClientSide) {
			return
		}
		extracted()

		if (tickCount > 60) {
			remove(RemovalReason.DISCARDED)
		}
	}

	private fun extracted() {
		if (isAttack || tickCount >= 2) {
			return
		}

		val level = level()
		val entityList = level.getEntitiesOfClass(Entity::class.java, boundingBox) { targetJudgment(it) }
		val i = entityList.size
		if (i == 0) {
			return
		}
		for (j in 0 until i) {
			val livingEntity: Entity = if (targetEntity != null && targetEntity!!.isAlive && targetEntity!!.isAttackable) {
				targetEntity!!
			} else {
				entityList[level.random.nextInt(i)]
			}
			if (!dealDamageTo(livingEntity)) {
				continue
			}
			hit(livingEntity)
			isAttack = true
			break
		}
	}

	fun hit(entity: Entity) {
		if (entity is LivingEntity) {
			entity.addEffect(MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 3))
		}
		val livingentity = owner ?: return
		val value = livingentity.random.nextInt(2, 4 + 1)
		livingentity.heal(value.toFloat())
		if (livingentity is Player) {
			RationalityUtil.modifyRationalityValue(livingentity, value.toFloat(), true, true)
		}
	}

	private fun dealDamageTo(target: Entity): Boolean {
		val livingentity = owner
		val damage = getDamage()

		val theSoul = LibDamageTypes.THE_SOUL
		if (livingentity == null && !(target.isAlive && !target.isInvulnerable && target.uuid == livingentity?.uuid)) {
			return target.hurt(getDamageSource(theSoul, livingentity), damage)
		}

		return !livingentity!!.isAlliedTo(target) && target.hurt(getDamageSource(theSoul, livingentity), damage)
	}

	private fun getDamageSource(
		theSoul: net.minecraft.resources.ResourceKey<net.minecraft.world.damagesource.DamageType>,
		livingentity: LivingEntity?
	): DamageSource {
		val source = damageSources().source(theSoul, this, livingentity)
		source.goldenboughs_lib$setLcDamageType(LcDamageType.THE_SOUL)
		source.goldenboughs_lib$setDamageLevel(LcLevel.ALEPH)
		return source
	}

	fun getDamage(): Float = damageCalculation(this.damage, this.damage1, this.damage2)

	private fun damageCalculation(damage: Float, damage1: Float, damage2: Float): Float {
		var d = damage
		if (targetNumber >= 2) {
			d = damage1
		}
		if (targetNumber >= 6) {
			d = damage2
		}
		return d
	}

	private fun targetJudgment(entity: Entity): Boolean {
		if (entity is ItemEntity ||
			entity is ExperienceOrb ||
			entity is ParadiseLostSpikeweed ||
			entity is Projectile
		) {
			return false
		}
		val owner = owner
		return owner != null && entity.uuid != owner.uuid
	}

	override fun getOwner(): LivingEntity? {
		if (owner != null ||
			ownerUUID == null ||
			level() !is ServerLevel ||
			(level() as ServerLevel).getEntity(ownerUUID!!) !is LivingEntity
		) {
			return owner
		}

		owner = (level() as ServerLevel).getEntity(ownerUUID!!) as LivingEntity
		return owner
	}

	fun setOwner(owner: LivingEntity?) {
		this.owner = owner
		this.ownerUUID = owner?.uuid
	}

	override fun getWeaponItem(): ItemStack? = owner?.mainHandItem

	override fun readAdditionalSaveData(compound: CompoundTag) {
		if (compound.hasUUID("Owner")) {
			ownerUUID = compound.getUUID("Owner")
		}
		if (compound.contains("Damage")) {
			damage = compound.getFloat("Damage")
		}
		if (compound.contains("Damage1")) {
			damage1 = compound.getFloat("Damage1")
		}
		if (compound.contains("Damage2")) {
			damage2 = compound.getFloat("Damage2")
		}
	}

	override fun addAdditionalSaveData(compound: CompoundTag) {
		ownerUUID?.let { compound.putUUID("Owner", it) }
		compound.putFloat("Damage", damage)
		compound.putFloat("Damage1", damage1)
		compound.putFloat("Damage2", damage2)
	}

	override fun handleEntityEvent(id: Byte) {
		super.handleEntityEvent(id)
		if (id.toInt() != 4) {
			return
		}

		clientSideAttackStarted = true
		if (isSilent) {
			return
		}
		val pitch = random.nextFloat() * 0.2F + 0.85F
		level().playLocalSound(
			x, y, z, SoundEvents.EVOKER_FANGS_ATTACK,
			soundSource, 1.0F, pitch, false
		)
	}

	override fun registerControllers(controllers: AnimatableManager.ControllerRegistrar) {}

	override fun getAnimatableInstanceCache(): AnimatableInstanceCache = anims

	fun getTargetNumber(): Int = targetNumber

	fun getAnimationProgress(partialTicks: Float): Float {
		if (!clientSideAttackStarted) {
			return 0.0F
		}
		val i = lifeTicks - 2
		return if (i <= 0) 1.0F else 1.0F - (i.toFloat() - partialTicks) / 20.0F
	}

	class TrainingRabbitsRenderer(context: EntityRendererProvider.Context) :
		GeoEntityRenderer<ParadiseLostSpikeweed>(context, GeoEntityModel(EGOEquipment.modRl("paradise_lost_spikeweed"))) {

		override fun getTextureLocation(animatable: ParadiseLostSpikeweed): ResourceLocation =
			GeoEntityModel.texturePath(EGOEquipment.modRl("paradise_lost_spikeweed"))
	}
}
