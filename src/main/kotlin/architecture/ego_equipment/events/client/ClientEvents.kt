package architecture.ego_equipment.events.client

import architecture.ego_equipment.client.gui.hudlayers.RedEyesTachiChopFlavor
import architecture.ego_equipment.init.item.EGOWeaponItems
import architecture.ego_equipment.util.EGOEquipmentUtil
import architecture.goldenboughs_lib.event.ChopFlavorLayerEvent
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber

@EventBusSubscriber(modid = EGOEquipmentUtil.ID, value = [Dist.CLIENT])
object ClientEvents {
	@SubscribeEvent
	fun onAddChopFlavorLayer(event: ChopFlavorLayerEvent) {
		event.add(
			EGOEquipmentUtil.modRl("red_eyes_tachi"),
			{ itemStack -> itemStack.`is`(EGOWeaponItems.RED_EYES_TACHI) },
			RedEyesTachiChopFlavor()
		)
	}
}