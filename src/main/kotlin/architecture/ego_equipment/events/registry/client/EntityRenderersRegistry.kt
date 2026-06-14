package architecture.ego_equipment.events.registry.client

import architecture.ego_equipment.client.renderer.entity.MagicBulletRenderer
import architecture.ego_equipment.init.EGOEquipmentProjectileEntityTypes
import architecture.ego_equipment.util.EGOEquipmentUtil
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.EntityRenderersEvent

@EventBusSubscriber(modid = EGOEquipmentUtil.ID, value = [Dist.CLIENT])
object EntityRenderersRegistry {
	@SubscribeEvent
	fun registry(event: EntityRenderersEvent.RegisterRenderers) {
		event.registerEntityRenderer(EGOEquipmentProjectileEntityTypes.MAGIC_BULLET_ENTITY.get(), ::MagicBulletRenderer)
	}
}
