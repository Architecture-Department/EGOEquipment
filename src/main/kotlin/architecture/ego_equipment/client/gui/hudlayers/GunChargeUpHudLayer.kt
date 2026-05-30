package architecture.ego_equipment.client.gui.hudlayers

import architecture.ego_equipment.common.item.weapon.remote.gun.MagicBulletWeaponItem
import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.goldenboughs_lib.api.world.item.IGunWeapon
import architecture.goldenboughs_lib.client.gui.hudlayers.BasicHudLayer
import architecture.goldenboughs_lib.client.gui.widget.ImageProgressBar.Companion.renderProgressBar
import architecture.goldenboughs_lib.util.GunWeaponUtil
import net.minecraft.client.AttackIndicatorStatus
import net.minecraft.client.DeltaTracker
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.HumanoidArm

class GunChargeUpHudLayer private constructor(
	private val attackIndicatorStatus: AttackIndicatorStatus
) : BasicHudLayer() {

	companion object {
		val REMOTE_BOTTOM: ResourceLocation = EGOEquipmentConstants.modRl("hud_bar/remote_bottom")
		val REMOTE_GUN: ResourceLocation = EGOEquipmentConstants.modRl("hud_bar/remote_gun")
		val REMOTE_MAGIC_BULLET: ResourceLocation = EGOEquipmentConstants.modRl("hud_bar/remote_magic_bullet")
		val BIG_REMOTE_BOTTOM: ResourceLocation = EGOEquipmentConstants.modRl("hud_bar/big_remote_bottom")
		val BIG_REMOTE_GUN: ResourceLocation = EGOEquipmentConstants.modRl("hud_bar/big_remote_gun")
		val BIG_REMOTE_MAGIC_BULLET: ResourceLocation = EGOEquipmentConstants.modRl("hud_bar/big_remote_magic_bullet")

		val INSTANCE_CROSSHAIR: GunChargeUpHudLayer = GunChargeUpHudLayer(AttackIndicatorStatus.CROSSHAIR)
		val INSTANCE_HOTBAR: GunChargeUpHudLayer = GunChargeUpHudLayer(AttackIndicatorStatus.HOTBAR)
	}

	private var mainHandValue: Float = 0f
	private var offHandValue: Float = 0f
	private var humanoidArm: HumanoidArm = HumanoidArm.RIGHT

	init {
		if (attackIndicatorStatus == AttackIndicatorStatus.OFF) {
			throw IllegalStateException("Unexpected value: $attackIndicatorStatus")
		}
	}

	override fun renderDrawLayer(guiGraphics: GuiGraphics, deltaTracker: DeltaTracker) {
		val mainHandItem = getPlayerThrow().mainHandItem
		val offHandItem = getPlayerThrow().offhandItem
		val mainHandItemItem = mainHandItem.item
		val offHandItemItem = offHandItem.item
		val isMainArmRight = humanoidArm == HumanoidArm.RIGHT

		val y = y
		when (attackIndicatorStatus) {
			AttackIndicatorStatus.CROSSHAIR -> {
				if (mainHandValue > 0 && mainHandItemItem is IGunWeapon) {
					val x = leftPos + (if (isMainArmRight) -16 / 2 + 15 else -16 / 2 - 15)
					guiGraphics.blitSprite(REMOTE_BOTTOM, x, y, 16, 16)
					val texture = if (mainHandItemItem is MagicBulletWeaponItem) REMOTE_MAGIC_BULLET else REMOTE_GUN
					guiGraphics.renderProgressBar(texture, x, y, 16, 16, mainHandValue, 1f, true, true)
				}
				if (offHandValue > 0 && !offHandItem.isEmpty && offHandItemItem is IGunWeapon) {
					val x = leftPos + (if (!isMainArmRight) -16 / 2 + 15 else -16 / 2 - 15)
					guiGraphics.blitSprite(REMOTE_BOTTOM, x, y, 16, 16)
					guiGraphics.renderProgressBar(REMOTE_GUN, x, y, 16, 16, offHandValue, 1f, true, true)
				}
			}

			AttackIndicatorStatus.HOTBAR -> {
				if (mainHandValue > 0 && !mainHandItem.isEmpty && mainHandItemItem is IGunWeapon) {
					val x = leftPos + (if (!isMainArmRight) -91 - 29 else 91)
					guiGraphics.blitSprite(BIG_REMOTE_BOTTOM, x, y, 32, 32)
					val texture = if (mainHandItemItem is MagicBulletWeaponItem) BIG_REMOTE_MAGIC_BULLET else BIG_REMOTE_GUN
					guiGraphics.renderProgressBar(texture, x, y, 32, 32, mainHandValue, 1f, true, true)
				}
				if (offHandValue > 0 && !offHandItem.isEmpty && offHandItemItem is IGunWeapon) {
					val x = leftPos + (if (isMainArmRight) -91 - 29 else 91)
					guiGraphics.blitSprite(BIG_REMOTE_BOTTOM, x, y, 32, 32)
					guiGraphics.renderProgressBar(BIG_REMOTE_GUN, x, y, 32, 32, offHandValue, 1f, true, true)
				}
			}

			else -> {}
		}
	}

	override fun init(guiGraphics: GuiGraphics, deltaTracker: DeltaTracker) {
		super.init(guiGraphics, deltaTracker)

		val mainVal = GunWeaponUtil.getChargeUpPercentage(getPlayerThrow(), InteractionHand.MAIN_HAND)
		if (mainHandValue != mainVal) {
			mainHandValue = mainVal
		}

		val offVal = GunWeaponUtil.getChargeUpPercentage(getPlayerThrow(), InteractionHand.OFF_HAND)
		if (offHandValue != offVal) {
			offHandValue = offVal
		}

		val mainArm = getPlayerThrow().mainArm
		if (mainArm != humanoidArm) {
			humanoidArm = mainArm
		}
	}

	override fun sizeChange(newScreenWidth: Int, newScreenHeight: Int) {
		super.sizeChange(newScreenWidth, newScreenHeight)
		if (player == null) {
			return
		}
		leftPos = newScreenWidth / 2
		when (attackIndicatorStatus) {
			AttackIndicatorStatus.CROSSHAIR -> topPos = newScreenHeight / 2 - 16 / 2
			AttackIndicatorStatus.HOTBAR -> topPos = newScreenHeight - 32
			else -> throw IllegalStateException("Unexpected value: $attackIndicatorStatus")
		}
	}
}
