package architecture.ego_equipment.common.item.weapon.remote.special

import architecture.ego_equipment.common.entity.projectile.ParadiseLostSpikeweed
import architecture.ego_equipment.common.item.weapon.remote.RemoteEgoWeaponGeoItem
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem
import net.minecraft.client.Minecraft
import net.minecraft.core.BlockPos
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.Projectile
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.phys.AABB
import net.minecraft.world.phys.shapes.VoxelShape
import software.bernie.geckolib.model.GeoModel

class ParadiseLostWeaponItem : RemoteEgoWeaponGeoItem {
	companion object {
		const val ATTACK = "player.paradise_lost.attack"
		const val CONTINUOUS_ATTACK = "player.paradise_lost.continuous_attack"
		const val END = "player.paradise_lost.end"

		@JvmStatic
		fun normalAttack(world: Level, attackingEntity: LivingEntity) {
			if (world !is ServerLevel) {
				return
			}
			val position = attackingEntity.eyePosition
			var x = 0.0
			var y = 0.0
			var z = 0.0
			val accuracy = 5
			for (scale in 0..30 * accuracy) {
				val vec3 = position.add(attackingEntity.lookAngle.scale(scale.toDouble() / accuracy))
				x = vec3.x
				y = vec3.y
				z = vec3.z
				val v = 2.0
				val aabb = AABB(x - v, y - v, z - v, x + v, y + v, z + v)
				val entityList = getAttackableTarget(attackingEntity, world, aabb)
				val i = entityList.size
				if (i > 0) {
					val livingEntity = entityList[attackingEntity.level().random.nextInt(i)]
					x = livingEntity.position().x
					y = livingEntity.blockPosition().y.toDouble()
					z = livingEntity.position().z
					break
				} else if (!isArrivable(x, y, z, world)) {
					break
				}
				while (isArrivable(x, y, z, world)) {
					y--
					if (y < -64) {
						y = vec3.y
						break
					}
				}
			}
			world.addFreshEntityWithPassengers(ParadiseLostSpikeweed.create(world, x, y, z, 1, attackingEntity))
		}

		private fun getAttackableTarget(
			attackingEntity: LivingEntity,
			serverLevel: ServerLevel,
			aabb: AABB
		): List<LivingEntity> =
			serverLevel.getEntitiesOfClass(
				LivingEntity::class.java, aabb
			) { livingEntity ->
				var playerCreative = false
				if (livingEntity is Player) {
					playerCreative = livingEntity.isCreative
				}
				livingEntity.uuid != attackingEntity.uuid && livingEntity.isAlive && livingEntity.isAttackable && !playerCreative
			}

		private fun isArrivable(x: Double, y: Double, z: Double, level: Level): Boolean {
			val pos = BlockPos(
				(if (x >= 0) x else x - 1).toInt(),
				(if (y >= 0) y else y - 1).toInt(),
				(if (z >= 0) z else z - 1).toInt()
			)
			return !isPointColliding(level, pos, x, y, z)
		}

		fun isPointColliding(level: Level, pos: BlockPos, worldX: Double, worldY: Double, worldZ: Double): Boolean {
			val state = level.getBlockState(pos)
			val shape: VoxelShape = state.getCollisionShape(level, pos)

			if (shape.isEmpty) {
				return false
			}

			val x = Math.abs(worldX - pos.x)
			val y = Math.abs(worldY - pos.y)
			val z = Math.abs(worldZ - pos.z)

			for (aabb in shape.toAabbs()) {
				if (aabb.contains(x, y, z)) {
					return true
				}
			}
			return false
		}

		@JvmStatic
		fun chargingAttack(world: Level, attackingEntity: LivingEntity) {
			if (world !is ServerLevel) {
				return
			}
			var x = attackingEntity.position().x
			var y = attackingEntity.blockPosition().y
			var z = attackingEntity.position().z
			val v = 8.0
			val aabb = AABB(x - v, y - 3.0, z - v, x + v, y + 3.0, z + v)
			val entityList = getAttackableTarget(attackingEntity, world, aabb)
			val i = entityList.size
			if (i > 0) {
				for (livingEntity in entityList) {
					x = livingEntity.position().x
					y = livingEntity.blockPosition().y
					z = livingEntity.position().z
					while (world.getBlockState(BlockPos(x.toInt(), y - 1, z.toInt())).isAir) {
						y--
						if (y < -64) {
							y = livingEntity.position().y.toInt()
							break
						}
					}
					world.addFreshEntityWithPassengers(
						ParadiseLostSpikeweed.create(
							world,
							x,
							y.toDouble(),
							z,
							i,
							attackingEntity,
							livingEntity
						)
					)
				}
			}
		}
	}

	private val NORMAL_ATTACK_TICK = 8
	private val CHARGING_ATTACK_TICK = 10

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

	override fun getUseDuration(itemStack: ItemStack, usingEntity: LivingEntity): Int = 666

	override fun use(world: Level, playerEntity: Player, handUsed: InteractionHand): InteractionResultHolder<ItemStack> {
		val itemstack = super.use(world, playerEntity, handUsed).`object`
		return InteractionResultHolder.success(itemstack)
	}

	override fun onUseTick(world: Level, usingEntity: LivingEntity, itemStack: ItemStack, remainingUseDuration: Int) {
		if (usingEntity !is Player || !usingEntity.onGround() || isJumpCancellation(world, usingEntity)) {
		}
	}

	private fun isJumpCancellation(world: Level, playerEntity: Player): Boolean {
		val minecraft = Minecraft.getInstance()
		if (minecraft.player != null) {
			if (minecraft.player!!.input.jumping) {
				forcedInterruption(world, playerEntity)
				return true
			}
		}
		return false
	}

	fun forcedInterruption(world: Level, playerEntity: Player) {
	}

	override fun onStopUsing(itemStack: ItemStack, usingEntity: LivingEntity, count: Int) {
		if (usingEntity !is Player) {
			return
		}
		super.onStopUsing(itemStack, usingEntity, count)
	}

	override fun inventoryTick(
		itemStack: ItemStack,
		world: Level,
		entity: Entity,
		slotIndex: Int,
		isCurrentlySelected: Boolean
	) {
		if (!isCurrentlySelected || entity !is Player || entity.isUsingItem) {
			return
		}
	}
}
