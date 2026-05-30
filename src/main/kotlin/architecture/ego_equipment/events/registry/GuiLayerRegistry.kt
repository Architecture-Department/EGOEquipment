package architecture.ego_equipment.events.registry

import architecture.ego_equipment.client.gui.hudlayers.GunChargeUpHudLayer
import architecture.ego_equipment.core.EGOEquipmentConstants
import architecture.goldenboughs_lib.client.LibGuiLayers
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent
import net.neoforged.neoforge.client.gui.VanillaGuiLayers

@EventBusSubscriber(modid = EGOEquipmentConstants.ID, value = [Dist.CLIENT])
object GuiLayerRegistry {
	@SubscribeEvent
	fun register(event: RegisterGuiLayersEvent) {
		event.registerAbove(
			VanillaGuiLayers.CROSSHAIR,
			LibGuiLayers.GUN_CHARGE_UP_HUD_LAYER_CROSSHAIR,
			GunChargeUpHudLayer.INSTANCE_CROSSHAIR
		)
		event.registerAbove(
			VanillaGuiLayers.HOTBAR,
			LibGuiLayers.GUN_CHARGE_UP_HUD_LAYER_HOTBAR,
			GunChargeUpHudLayer.INSTANCE_HOTBAR
		)
	}
}
