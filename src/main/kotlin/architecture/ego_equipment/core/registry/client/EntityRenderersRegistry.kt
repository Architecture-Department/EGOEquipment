package architecture.ego_equipment.core.registry.client

import architecture.ego_equipment.client.renderer.entity.MagicBulletRenderer
import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.ego_equipment.init.EGOEquipmentProjectileEntityTypes
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.EntityRenderersEvent

@EventBusSubscriber(modid = EGOEquipmentConstants.ID, value = [Dist.CLIENT])
object EntityRenderersRegistry {
	@SubscribeEvent
	fun registry(event: EntityRenderersEvent.RegisterRenderers) {
		event.registerEntityRenderer(EGOEquipmentProjectileEntityTypes.MAGIC_BULLET_ENTITY.get(), ::MagicBulletRenderer)
	}
}
