package architecture.ego_equipment.events.client

import architecture.ego_equipment.client.renderer.item.MagicBulletMagicCircleRenderer
import architecture.ego_equipment.core.EGOEquipmentConstants
import net.minecraft.client.player.AbstractClientPlayer
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.RenderPlayerEvent

@EventBusSubscriber(modid = EGOEquipmentConstants.ID, value = [Dist.CLIENT])
object PlayerRenderEvents {

	@SubscribeEvent
	fun playerRender(event: RenderPlayerEvent.Post) {
		val multiBufferSource = event.multiBufferSource
		val partialTick = event.partialTick
		val entity = event.entity as AbstractClientPlayer
		MagicBulletMagicCircleRenderer.magicBulletMagicCircle(entity, partialTick, multiBufferSource)
	}
}
