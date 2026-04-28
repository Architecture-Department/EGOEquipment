package architecture.ego_equipment.core.registry.client;

import architecture.ego_equipment.client.renderer.entity.MagicBulletRenderer;
import architecture.ego_equipment.core.EGOEquipment;
import architecture.ego_equipment.init.EGOEquipmentProjectileEntityTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = EGOEquipment.ID, value = Dist.CLIENT)
public final class EntityRenderersRegistry {
	@SubscribeEvent
	public static void registry(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EGOEquipmentProjectileEntityTypes.MAGIC_BULLET_ENTITY.get(), MagicBulletRenderer::new);
	}
}
