package architecture.ego_equipment.events.client;

import architecture.ego_equipment.client.renderer.item.MagicBulletMagicCircleRenderer;
import architecture.ego_equipment.core.EGOEquipment;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;

@EventBusSubscriber(modid = EGOEquipment.ID, value = Dist.CLIENT)
public final class PlayerRenderEvents {

	@SubscribeEvent
	public static void playerRender(final RenderPlayerEvent.Post event) {
		MultiBufferSource multiBufferSource = event.getMultiBufferSource();
		float partialTick = event.getPartialTick();
		AbstractClientPlayer entity = (AbstractClientPlayer) event.getEntity();
		MagicBulletMagicCircleRenderer.magicBulletMagicCircle(entity, partialTick, multiBufferSource);
	}
}
