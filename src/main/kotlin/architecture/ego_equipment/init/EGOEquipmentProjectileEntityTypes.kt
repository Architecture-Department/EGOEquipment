package architecture.ego_equipment.init

import architecture.ego_equipment.common.entity.projectile.MagicBulletEntity
import architecture.ego_equipment.common.entity.projectile.ParadiseLostSpikeweed
import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.datagen.i18n.ZhCn
import architecture.goldenboughs_lib.api.LcLevel
import architecture.goldenboughs_lib.util.LcLevelUtil
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import architecture.ego_equipment.core.EGOEquipmentConstants

object EGOEquipmentProjectileEntityTypes {
	val REGISTRY: DeferredRegister<EntityType<*>> = EGOEquipmentConstants.modRegister(BuiltInRegistries.ENTITY_TYPE)

	val PARADISE_LOST_SPIKEWEED: DeferredHolder<EntityType<*>, EntityType<ParadiseLostSpikeweed>> = register(
		"paradise_lost_spikeweed",
		"失乐园尖刺",
		LcLevel.ALEPH,
		EntityType.Builder.of(::ParadiseLostSpikeweed, MobCategory.MISC)
			.sized(2F, 2.5F)
			.clientTrackingRange(6)
			.updateInterval(2)
	)

	val MAGIC_BULLET_ENTITY: DeferredHolder<EntityType<*>, EntityType<MagicBulletEntity>> = register(
		"magic_bullet",
		"魔弹",
		LcLevel.WAW,
		EntityType.Builder.of(::MagicBulletEntity, MobCategory.MISC)
			.sized(0.2F, 0.2F)
			.clientTrackingRange(6)
			.updateInterval(1)
	)

	fun init(bus: IEventBus) {
		REGISTRY.register(bus)
	}

	private fun <I : Entity> register(
		name: String, zhName: String, lcLevel: LcLevel, sup: EntityType.Builder<I>
	): DeferredHolder<EntityType<*>, EntityType<I>> = register(name, zhName, lcLevel) { sup.build(name) }

	private fun <T : Entity> register(
		name: String, zhName: String, lcLevel: LcLevel, sup: () -> EntityType<T>
	): DeferredHolder<EntityType<*>, EntityType<T>> {
		val holder = REGISTRY.register(name, sup)
		LcLevelUtil.lcLevel(lcLevel, holder)
		ZhCn.addI18nEntityTypeText(zhName, holder)
		return holder
	}
}
