package architecture.ego_equipment.common.item.weapon.remote

import architecture.goldenboughs_lib.api.LcDamageType
import architecture.goldenboughs_lib.api.capability.item.IItemUsageReq
import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.item.*
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import java.util.function.Predicate

abstract class RemoteEgoWeaponItem : ProjectileWeaponItem, IItemUsageReq, IRemoteEgoWeaponItem {
	private val lcDamageType: LcDamageType?
	private val canCauseLcDamageTypes: Set<LcDamageType>
	private val attackDistance: Float
	private val createProjectile: IRemoteEgoWeaponItem.CreateProjectile<out Projectile>?

	constructor(itemProperties: Properties, builder: IRemoteEgoWeaponItem.Builder) : super(
		IEgoWeaponItem.add(itemProperties, builder)
	) {
		this.attackDistance = builder.attackDistance
		this.createProjectile = builder.createProjectile
		this.lcDamageType = builder.lcDamageType
		this.canCauseLcDamageTypes = builder.canCauseLcDamageTypes
	}

	override fun getDefaultProjectileRange(): Int = attackDistance.toInt()

	fun getDamage(entity: LivingEntity, itemStack: ItemStack, handUsed: InteractionHand): Float =
		entity.getAttributeValue(Attributes.ATTACK_DAMAGE).toFloat()

	fun getProjectileRange(entity: LivingEntity, itemStack: ItemStack, handUsed: InteractionHand): Float =
		attackDistance

	fun getProjectileInaccuracy(entity: LivingEntity, itemStack: ItemStack, handUsed: InteractionHand): Float = 0f

	fun getProjectileVelocity(entity: LivingEntity, itemStack: ItemStack, handUsed: InteractionHand): Float = 10.0F

	protected fun notConsumingShoot(
		world: ServerLevel, shooterEntity: LivingEntity, handUsed: InteractionHand, weaponItem: ItemStack,
		projectileVelocity: Float, projectileInaccuracy: Float, targetEntity: LivingEntity?
	) {
		val projectile = this.createProjectile(world, shooterEntity, weaponItem, null)
		this.shootProjectile(shooterEntity, projectile, 0, projectileVelocity, projectileInaccuracy, 0f, targetEntity)
		world.addFreshEntity(projectile)
	}

	protected fun createProjectile(
		world: Level, shooterEntity: LivingEntity, weaponItem: ItemStack,
		ammoItem: ItemStack?
	): Projectile {
		if (this.createProjectile != null && ammoItem != null) {
			return this.createProjectile.createProjectile(world, shooterEntity, weaponItem, ammoItem)
		}
		val ammo1 = Items.ARROW.defaultInstance
		val arrowitem = ammo1.item as? ArrowItem ?: Items.ARROW as ArrowItem
		val abstractarrow = arrowitem.createArrow(world, ammo1, shooterEntity, weaponItem)
		abstractarrow.isCritArrow = true
		return customArrow(abstractarrow, ammo1, weaponItem)
	}

	override fun canAttackBlock(
		blockState: BlockState,
		world: Level,
		blockPosition: BlockPos,
		playerEntity: Player
	): Boolean =
		!playerEntity.isCreative

	override fun getUseDuration(itemStack: ItemStack, usingEntity: LivingEntity): Int = Int.MAX_VALUE

	override fun getUseAnimation(stack: ItemStack): UseAnim = UseAnim.NONE

	override fun createProjectile(
		world: Level, shooterEntity: LivingEntity, weaponItem: ItemStack,
		ammoItem: ItemStack, isCrit: Boolean
	): Projectile = if (this.createProjectile != null)
		this.createProjectile.createProjectile(world, shooterEntity, weaponItem, ammoItem)
	else
		super.createProjectile(world, shooterEntity, weaponItem, Items.ARROW.defaultInstance, isCrit)

	override fun getSupportedHeldProjectiles(itemStack: ItemStack): Predicate<ItemStack> = Predicate { false }

	@Suppress("deprecation")
	override fun getSupportedHeldProjectiles(): Predicate<ItemStack> = Predicate { false }

	override fun getAllSupportedProjectiles(itemStack: ItemStack): Predicate<ItemStack> = Predicate { false }

	override fun getAllSupportedProjectiles(): Predicate<ItemStack> = Predicate { false }

	override fun getDefaultCreativeAmmo(playerEntity: Player?, projectileWeaponItem: ItemStack): ItemStack =
		Items.AIR.defaultInstance

	override fun getLcDamageType(stack: ItemStack): LcDamageType? = lcDamageType

	override fun getCanCauseLcDamageTypes(stack: ItemStack): Set<LcDamageType> = canCauseLcDamageTypes
}
