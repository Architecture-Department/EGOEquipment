package architecture.ego_equipment.client.renderer.item

import architecture.ego_equipment.core.EGOEquipment
import net.minecraft.client.player.AbstractClientPlayer
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.RenderType

object MagicBulletMagicCircleRenderer {
	val MAGIC_CIRCLE_16X: RenderType = architecture.goldenboughs_lib.client.LibRenderTypes.magicBulletMagicCircle(
		EGOEquipment.modRl("textures/particle/magic_bullet/magic_circle16x.png")
	)
	val MAGIC_CIRCLE_32X: RenderType = architecture.goldenboughs_lib.client.LibRenderTypes.magicBulletMagicCircle(
		EGOEquipment.modRl("textures/particle/magic_bullet/magic_circle32x.png")
	)
	val MAGIC_CIRCLE_128X: RenderType = architecture.goldenboughs_lib.client.LibRenderTypes.magicBulletMagicCircle(
		EGOEquipment.modRl("textures/particle/magic_bullet/magic_circle128x.png")
	)

	@JvmStatic
	fun magicBulletMagicCircle(entity: AbstractClientPlayer?, partialTick: Float, multiBufferSource: MultiBufferSource?) {
	}
}
