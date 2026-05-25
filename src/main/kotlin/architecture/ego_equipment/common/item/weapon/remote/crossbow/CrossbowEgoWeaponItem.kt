package architecture.ego_equipment.common.item.weapon.remote.crossbow

import architecture.goldenboughs_lib.api.LcDamageType
import architecture.goldenboughs_lib.api.world.item.IEgoWeaponItem
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.item.ArrowItem
import net.minecraft.world.item.CrossbowItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.level.Level

class CrossbowEgoWeaponItem(
	itemProperties: Properties,
	builder: IRemoteEgoWeaponItem.Builder
) : CrossbowItem(IEgoWeaponItem.add(itemProperties, builder)), IRemoteEgoWeaponItem {
	private val attackDistance: Float = builder.attackDistance
	private val createProjectile: IRemoteEgoWeaponItem.CreateProjectile<out Projectile>? = builder.createProjectile

	override fun getDefaultProjectileRange(): Int = attackDistance.toInt()

	fun getProjectileRange(entity: LivingEntity, itemStack: ItemStack, handUsed: InteractionHand): Float = attackDistance
	override fun createProjectile(
		level: Level,
		shooter: LivingEntity,
		weapon: ItemStack,
		ammo: ItemStack,
		isCrit: Boolean
	): Projectile =
		if (this.createProjectile != null) this.createProjectile.createProjectile(level, shooter, weapon, ammo)
		else super.createProjectile(level, shooter, weapon, Items.ARROW.defaultInstance, isCrit)

	fun notConsumingShoot(
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

	override fun getLcDamageType(stack: ItemStack): LcDamageType? = null
}
