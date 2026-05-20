package architecture.ego_equipment.client.gui.hudlayers

import architecture.ego_equipment.core.EGOEquipment
import architecture.ego_equipment.init.EGOEquipmentMobEffects
import architecture.goldenboughs_lib.client.gui.hudlayers.chop_flavor.ChopFlavorLayer
import architecture.goldenboughs_lib.client.gui.widget.ImageProgressBar
import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.DeltaTracker
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.player.LocalPlayer
import net.minecraft.resources.ResourceLocation

class RedEyesTachiChopFlavor : ChopFlavorLayer.ChopFlavorBar() {
	companion object {
		val BOTTOM: ResourceLocation = EGOEquipment.modRl("chop_flavor/red_eyes_tachi/bottom")
		val BOTTOM_GLOWMASK: ResourceLocation = EGOEquipment.modRl("chop_flavor/red_eyes_tachi/bottom_glowmask")
		val SCABBARD: ResourceLocation = EGOEquipment.modRl("chop_flavor/red_eyes_tachi/scabbard")
		val SCABBARD_ACTION: ResourceLocation = EGOEquipment.modRl("chop_flavor/red_eyes_tachi/scabbard_action")
		const val WIDTH = 32
		const val HEIGHT = 16
	}

	private var time: Float = 0f
	private var castSkill: Int = 0

	override fun render(guiGraphics: GuiGraphics, deltaTracker: DeltaTracker, x: Int, y: Int) {
		val pose = guiGraphics.pose()
		pose.pushPose()
		pose.translate(x.toFloat(), y.toFloat(), 0f)
		pose.scale(2f, 2f, 2f)
		pose.translate(-WIDTH.toFloat() / 2, 0f, 0f)

		val player: LocalPlayer = ChopFlavorLayer.INSTANCE.playerThrow
		val effect = player.getEffect(EGOEquipmentMobEffects.RED_EYES_HUNTING)
		guiGraphics.blitSprite(BOTTOM, 0, 0, WIDTH, HEIGHT)

		if (false) {
			guiGraphics.setColor(2f, 2f, 2f, 1f)
			guiGraphics.blitSprite(BOTTOM_GLOWMASK, 0, 0, WIDTH, HEIGHT)
			guiGraphics.setColor(1f, 1f, 1f, 1f)
		}

		val value: Int
		val maxValue: Int
		if (effect == null) {
			value = 1
			maxValue = 1
		} else {
			maxValue = if (false) 200 else 100
			value = maxValue - effect.duration
		}

		if (castSkill != 1) {
			ImageProgressBar.renderProgressBar(
				guiGraphics,
				SCABBARD,
				11,
				0,
				11,
				0,
				WIDTH,
				HEIGHT,
				value,
				maxValue,
				false,
				true
			)
			time = 0f
		}

		if (castSkill == 1) {
			val i = time.toInt()
			guiGraphics.blitSprite(SCABBARD_ACTION, WIDTH, 352, 0, HEIGHT * i, 0, 0, WIDTH, HEIGHT)
			time += deltaTracker.realtimeDeltaTicks
			if (i >= (352 / HEIGHT) - 1) {
				castSkill = 0
			}
		}

		pose.popPose()
	}

	override fun castSkill() {
		val player: LocalPlayer = ChopFlavorLayer.INSTANCE.playerThrow
		val effect = player.getEffect(EGOEquipmentMobEffects.RED_EYES_HUNTING)
		if (effect == null) {
			castSkill = 1
		}
	}
}
