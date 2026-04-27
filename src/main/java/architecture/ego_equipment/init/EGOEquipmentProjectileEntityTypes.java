package architecture.ego_equipment.init;

import architecture.ego_equipment.common.entity.projectile.MagicBulletEntity;
import architecture.ego_equipment.common.entity.projectile.ParadiseLostSpikeweed;
import architecture.ego_equipment.core.EGOEquipment;
import architecture.ego_equipment.datagen.i18n.ZhCn;
import architecture.goldenboughs_lib.api.LcLevel;
import architecture.goldenboughs_lib.util.LcLevelUtil;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class EGOEquipmentProjectileEntityTypes {
	public static final DeferredRegister<EntityType<?>> REGISTRY = EGOEquipment.modRegister(BuiltInRegistries.ENTITY_TYPE);

	public static final DeferredHolder<EntityType<?>, EntityType<ParadiseLostSpikeweed>> PARADISE_LOST_SPIKEWEED = register(
		"paradise_lost_spikeweed",
		"失乐园尖刺",
		LcLevel.ALEPH,
		EntityType.Builder.of(ParadiseLostSpikeweed::new, MobCategory.MISC)
			.sized(2F, 2.5F)
			.clientTrackingRange(6)
			.updateInterval(2));

	public static final DeferredHolder<EntityType<?>, EntityType<MagicBulletEntity>> MAGIC_BULLET_ENTITY = register(
		"magic_bullet",
		"魔弹",
		LcLevel.WAW,
		EntityType.Builder.<MagicBulletEntity>of(MagicBulletEntity::new, MobCategory.MISC)
			.sized(0.2F, 0.2F)
			.clientTrackingRange(6)
			.updateInterval(1));

	static void init(IEventBus bus) {
		REGISTRY.register(bus);
	}

	private static <I extends Entity> DeferredHolder<EntityType<?>, EntityType<I>> register(
		String name, String zhName, LcLevel lcLevel, EntityType.Builder<I> sup
	) {
		return register(name, zhName, lcLevel, () -> sup.build(name));
	}

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(
		String name, String zhName, LcLevel lcLevel, Supplier<EntityType<T>> sup
	) {
		DeferredHolder<EntityType<?>, EntityType<T>> holder = REGISTRY.register(name, sup);
		LcLevelUtil.lcLevel(lcLevel, holder);
		ZhCn.addI18nEntityTypeText(zhName, holder);
		return holder;
	}
}
