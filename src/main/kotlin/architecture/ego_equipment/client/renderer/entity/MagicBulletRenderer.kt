package architecture.ego_equipment.client.renderer.entity

import architecture.ego_equipment.common.entity.projectile.MagicBulletEntity
import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.entity.EntityRenderer
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation

class MagicBulletRenderer(context: EntityRendererProvider.Context) : EntityRenderer<MagicBulletEntity>(context) {

	override fun getTextureLocation(entity: MagicBulletEntity): ResourceLocation =
		ResourceLocation.fromNamespaceAndPath("imaginarycraft", "textures/particle/solemn_lament/butterfly_white.png")

	override fun render(
		entity: MagicBulletEntity, entityYaw: Float, partialTicks: Float,
		poseStack: PoseStack, buffer: MultiBufferSource, packedLight: Int
	) {
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight)
	}
}
