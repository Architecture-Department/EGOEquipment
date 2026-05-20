package architecture.ego_equipment.client.renderer.item

import architecture.ego_equipment.common.item.weapon.melee.special.RedEyesTachiItem
import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.EGOEquipmentMobEffects
import architecture.goldenboughs_lib.client.renderer.GeoItemRendererExpand
import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.blaze3d.vertex.VertexConsumer
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemDisplayContext
import net.minecraft.world.item.ItemStack
import software.bernie.geckolib.cache.object.BakedGeoModel
import software.bernie.geckolib.model.GeoModel
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer

class RedEyesTachiItemWeaponRenderer(
	model: GeoModel<RedEyesTachiItem>,
	guiModel: GeoModel<RedEyesTachiItem>?
) : GeoItemRendererExpand<RedEyesTachiItem>(model, guiModel) {

	companion object {
		val GLOWMASK_TEXTURE: ResourceLocation = EGOEquipment.modRl("textures/geo/item/weapon/red_eyes_tachi_glowmask.png")
		val GEO_HUNTIOG_TEXTURE: ResourceLocation =
			EGOEquipment.modRl("textures/geo/item/weapon/red_eyes_tachi_hunting.png")
		val HUNTIOG_TEXTURE: ResourceLocation = EGOEquipment.modRl("textures/item/weapon/red_eyes_tachi_hunting.png")
	}

	private var isHunting: Boolean = false
	private var livingEntity: LivingEntity? = null

	init {
		val weaponRenderer = this
		addRenderLayer(object : AutoGlowingGeoLayer<RedEyesTachiItem>(this) {
			override fun getRenderType(animatable: RedEyesTachiItem, bufferSource: MultiBufferSource?): RenderType {
				if (weaponRenderer.renderPerspective != ItemDisplayContext.GUI) {
					return RenderType.eyes(GLOWMASK_TEXTURE)
				}
				return super.getRenderType(animatable, bufferSource)
			}

			override fun render(
				poseStack: PoseStack, animatable: RedEyesTachiItem, bakedModel: BakedGeoModel,
				renderType: RenderType?, bufferSource: MultiBufferSource, buffer: VertexConsumer?,
				partialTick: Float, packedLight: Int, packedOverlay: Int
			) {
				if (weaponRenderer.renderPerspective == ItemDisplayContext.GUI) {
					return
				}
				super.render(
					poseStack,
					animatable,
					bakedModel,
					renderType,
					bufferSource,
					buffer,
					partialTick,
					packedLight,
					packedOverlay
				)
			}
		})
	}

	override fun getTextureLocation(animatable: RedEyesTachiItem): ResourceLocation {
		if (isHunting) {
			if (renderPerspective == ItemDisplayContext.GUI) {
				return HUNTIOG_TEXTURE
			}
			return GEO_HUNTIOG_TEXTURE
		}
		return super.getTextureLocation(animatable)
	}

	override fun renderByItem(
		livingEntity: LivingEntity?, itemStack: ItemStack, displayContext: ItemDisplayContext,
		poseStack: PoseStack, bufferSource: MultiBufferSource, combinedLight: Int, combinedOverlay: Int
	) {
		extracted(livingEntity, displayContext)
		super.renderByItem(livingEntity, itemStack, displayContext, poseStack, bufferSource, combinedLight, combinedOverlay)
	}

	private fun extracted(livingEntity: LivingEntity?, displayContext: ItemDisplayContext) {
		this.livingEntity = livingEntity
		if (displayContext == ItemDisplayContext.GUI) {
			this.livingEntity = Minecraft.getInstance().player
		}

		if (this.livingEntity != null && this.livingEntity!!.hasEffect(EGOEquipmentMobEffects.RED_EYES_HUNTING)) {
			isHunting = true
		}
	}

	override fun doPostRenderCleanup() {
		super.doPostRenderCleanup()
		isHunting = false
		livingEntity = null
	}
}
