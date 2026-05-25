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
import architecture.ego_equipment.core.EGOEquipmentConstants

@EventBusSubscriber(modid = EGOEquipmentConstants.ID, value = [Dist.CLIENT])
object ParticleProvidersRegistry {
	@SubscribeEvent
	fun registry(event: RegisterParticleProvidersEvent) {
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.DYEING_MAGIC_CIRCLE.get(),
			DyeingMagicCircleParticle::Provider
		)
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.MAGIC_BULLET_MAGIC_CIRCLE.get(),
			MagicBulletMagicCircleParticle::Provider
		)
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_BLACK.get(),
			ButterflyParticle::Provider
		)
		event.registerSpriteSet(
			EGOEquipmentParticleTypes.SOLEMN_LAMENT_BUTTERFLY_WHITE.get(),
			ButterflyParticle::Provider
		)
	}
}
