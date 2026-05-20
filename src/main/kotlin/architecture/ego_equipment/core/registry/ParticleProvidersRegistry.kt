package architecture.ego_equipment.core.registry

import architecture.ego_equipment.client.particle.DyeingMagicCircleParticle
import architecture.ego_equipment.client.particle.magicbullet.MagicBulletMagicCircleParticle
import architecture.ego_equipment.client.particle.solemnlament.ButterflyParticle
import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.EGOEquipmentParticleTypes
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent

@EventBusSubscriber(modid = EGOEquipment.ID, value = [Dist.CLIENT])
object ParticleProvidersRegistry {
	@SubscribeEvent
	@JvmStatic
	fun registry(event: RegisterParticleProvidersEvent) {
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.DYEING_MAGIC_CIRCLE.get(),
			DyeingMagicCircleParticle.Provider::new
		)
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.MAGIC_BULLET_MAGIC_CIRCLE.get(),
			MagicBulletMagicCircleParticle.Provider::new
		)
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_BLACK.get(),
			ButterflyParticle.Provider::new
		)
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_WHITE.get(),
			ButterflyParticle.Provider::new
		)
	}
}
